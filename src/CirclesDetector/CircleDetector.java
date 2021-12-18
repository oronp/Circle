package CirclesDetector;

public class CircleDetector {
    public static void main(String args[]){
        char[][] matrix = {{1,2,3,4,5},{1,2,3,4,5},{1,2,'a',4,5}};

    }

    public static String Find_Circles(char[][] array){
        boolean[][] marked = new boolean[array.length][array[0].length];
        int numOfRows = array.length;
        int numOfCols = array[0].length;
        for(int i = 1; i < numOfRows; i++){
            for(int j = 1; j < numOfCols; j++){
                if(!NoNeighbours(array,i,j)){
                    if(ColSus(array,i) == true){

                    }
                }
            }
        }
        return "a";
    }

    public static int RowSus(char[] array,int correntCol){
        return 1;
    }//return the radius.

    public static boolean ColSus(char[][] array,int correntRow){
        return true;
    }//return if the radius is right for the collumn too.

    public static boolean Crosses(char[][] array,int correntRow,int correntCol,int size){
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
