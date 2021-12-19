package CirclesDetector;

public class CircleDetector {
    public static void main(String args[]){
        char[][] matrix = {{'0','7','E','E','B','1'},{'6','5','F','B','3','B'},{'E','F','C','F','B','A'},{'F','D','0','1','F','1'},{'C','F','5','F','5','4'},{'6','2','F','E','D','B'}};
        System.out.println(Find_Circles(matrix));
    }

    public static String Find_Circles(char[][] array){
        boolean[][] marked = new boolean[array.length][array[0].length]; //array of the centres.
        String centers = "The Circles Centers are: \n";
        int numOfRows = array.length;
        int numOfCols = array[0].length;
        for(int i = 1; i < numOfRows; i++){
            for(int j = 1; j < numOfCols; j++){
                if(!NoNeighbours(array,i,j)){
                    int rad = RowSus(array[i],j);
                    if(rad != -1 && ColSus(array,i,j,rad) == true && Crosses(array,i,j,rad)){
                        marked[i][j] = true;
                        //System.out.println("("+i+","+j+") -> " + array[i + rad][j]);
                        centers += "("+i+","+j+") -> " + array[i + rad][j] + "\n";
                    }
                }
            }
        }
        return centers;
    }

    public static int RowSus(char[] array,int correntCol){
        int maxRadius = Math.min(correntCol,array.length-correntCol - 1); // the maximum radius the circle can be (left to right).
        for(int i = 1; i <= maxRadius; i++){
            if(array[correntCol - i] == array[correntCol + i]){
                return i;
            }
        }
        return -1;
    }//return the radius. (if there are no matching letters -> return -1;

    public static boolean ColSus(char[][] array,int correntRow,int correntCol,int maybeRad){
        int maxRadius = Math.min(correntRow,array[0].length -correntRow - 1); // the maximum radius the circle can be (up&down).
        if(maxRadius < maybeRad)
            return false; // checks if the horizon radius is bigger the maxRadius so there is no chance for a circle.
        if(array[correntRow + maybeRad][correntCol] == array[correntRow - maxRadius][correntCol])
            return true;
        return false;
    }//return if the radius is right for the collumn too.

    public static boolean Crosses(char[][] array,int correntRow,int correntCol,int rad){
        char letter = array[correntRow + rad][correntCol];
        int radiusX = correntCol - rad;
        int radiusY = correntRow;
        int distX = rad;
        int distY = 0;
        while(radiusY != (correntRow + rad)){
            if(array[radiusY][radiusX] != letter && array[radiusX][radiusY] != letter)
                return false;
            if(array[correntRow + distY][correntCol + distX] != letter && array[correntRow - distY][correntCol - distX] != letter)
                return false;
            distX--;
            distY++;
            radiusX++;
            radiusY++;
        }
        return true;
    }//checks the whole frame of the circle.

    public static boolean NoNeighbours(char[][] Arr, int row, int col){
        int numOfRows = Arr.length;
        int numOfCols = Arr[0].length;
        char corrent = Arr[row][col];
        if((row+1 < numOfRows) && (Arr[row+1][col] == corrent))
            return true;
        if((row-1 > 0) && (Arr[row-1][col] == corrent))
            return true;
        if((col+1 < numOfCols) && (Arr[row][col+1] == corrent))
            return true;
        if((col-1 < numOfCols) && (Arr[row][col-1] == corrent))
            return true;
        return false;
    } // doing the same as written in the PDF file.
}
