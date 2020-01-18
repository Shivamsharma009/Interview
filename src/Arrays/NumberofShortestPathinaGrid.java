package Arrays;

/**
 * Given two number N and M. The task is to find the number of shortest paths to reach the cell(i, j)
 * in the grid of size N × M when the moves started from the bottom-left corner
 */
public class NumberofShortestPathinaGrid {

    //Fuction to find Shortest path in a Grid
    static void NumberofShortestPath(int n,int m)
    {
        int[][] a = new int[n][m];

        for(int i = n-1;i >=0;i--)
        {
            for(int j = 0; j< m;j++)
            {
                if(j==0 ||  i == n-1)
                    a[i][j] = 1;
                else
                    a[i][j] = a[i][j-1] + a[i+1][j];
            }
        }

        //print the Grid
        for(int i =0;i< n;i++)
        {
            for(int j =0;j< m;j++)
            {
                System.out.print(a[i][j] + "   ");
            }
            System.out.println();
        }
    }

    //Driver Program
    public static void main(String[] args)
    {
        int n = 3,m = 4;
        //Function Call in a Grid
        NumberofShortestPath(n,m);
    }
}
