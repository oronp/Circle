package CirclesDetector;

public class CircleDetector {
    public static void main(String args[]){
        char[][] matrix = {{1,2,3,4,5},{1,2,3,4,5},{1,2,'a',4,5}};
        //System.out.println(NoNeighbours(matrix,2,2));
        System.out.println(Find_Circles(matrix));
    }

    public static String Find_Circles(char[][] Array){
        boolean[][] marked = new boolean[Array.length][Array[0].length];
        System.out.println(marked[2][1]);
        marked[2][1] = true;
        System.out.println(marked[2][1]);
        return "a";
    }

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
