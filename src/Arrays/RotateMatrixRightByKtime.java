package Arrays;
import java.io.*;
public class RotateMatrixRightByKtime{

    //size of the matrix
    private static final int M =3;
    private static  final int N = 3;

    //Function to Rotate the matrix right by k times
    private static void RotateMatrix(int[][] mat, int k)
    {
        int []temp = new int[M];
        for(int i = 0;i < N ;i++)
        {
            //copy the M-k element in the array
            for(int t = 0;t < M-k;t++)
                temp[t]= mat[i][t];
            //Shift all the Remaining element to the right
            for(int j = M-k; j < M; j++)
                mat[i][j- M+k] = mat[i][j];
            //shift the last element from the tmp array to right
            for(int j = k;j < M ;j++)
                mat[i][j] = temp[j - k];
        }
    }

    //Function to display the matrix
    private static void displayMatrix(int[][] mat) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(mat[i][j] + "    ");
                System.out.println();

        }
    }
    //Driver Program
    public static void main(String[] args)
    {

        int[][] mat = new int[][]{{12, 23, 34},
                                  {45, 56, 67},
                                  {78, 89, 91}};

        int k =2;
        //Rotate matrix by k time
        RotateMatrix(mat,k);

        //display matrix
        displayMatrix(mat);
    }
}
