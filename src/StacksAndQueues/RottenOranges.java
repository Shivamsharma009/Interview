package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static class Pair{
        int i =0;
        int j = 0;

        Pair(int i , int j )
        {
            this.i = i;
            this.j = j;
        }
    }

    public static  boolean isValid(int i ,int j , int m ,int n)
    {
        if(i < 0 || j < 0 || i >=m ||j >=n) {
            return false;
        }
        return true;
    }

    public static  int rotton(int arr[][] ,int m ,int n)
    {
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i = 0 ; i < m ;i++)
        {
            for(int j = 0 ; j < n ;j++)
            {
                if(arr[i][j] == 2){
                    q.add(new Pair(i,j));
                }
            }
        }
        q.add(null);
        int ans = 0;

        while(!q.isEmpty()) {
            boolean flag = false;
            while (q.peek() != null) {
                Pair temp = q.peek();
                if (isValid(temp.i + 1, temp.j, m, n) && arr[temp.i + 1][temp.j] == 1) {
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    arr[temp.i + 1][temp.j] = 2;
                    q.add(new Pair(temp.i + 1, temp.j));
                }
                if (isValid(temp.i, temp.j + 1, m, n) && arr[temp.i][temp.j + 1] == 1) {
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    arr[temp.i][temp.j + 1] = 2;
                    q.add(new Pair(temp.i, temp.j + 1));
                }
                if (isValid(temp.i - 1, temp.j, m, n) && arr[temp.i - 1][temp.j] == 1) {
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    arr[temp.i - 1][temp.j] = 2;
                    q.add(new Pair(temp.i - 1, temp.j));
                }
                if (isValid(temp.i, temp.j - 1, m, n) && arr[temp.i][temp.j - 1] == 1) {
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    arr[temp.i][temp.j - 1] = 2;
                    q.add(new Pair(temp.i, temp.j - 1));
                }
                q.poll(); // remove 1 timeframe rotten orange
            }
            q.poll(); //remove null
            //Add null for checkpoint
            if (!q.isEmpty())
                q.add(null);
        }
        for(int i = 0 ;i > m; i++)
        {
            for(int j = 0; j > n; j++)
            {
                if(arr[i][j] == 1){
                    ans = -1;
                    break;
                }
            }
        }
        return ans;
    }

    //Driver Program
    public static  void main(String[] args)
    {
        int [][]field = {{2,1,0,2,1},
                         {1,0,1,2,1},
                         {1,0,0,2,1}};
        int m = 3;
        int n = 5;
        int ans =  rotton(field,m,n);
        System.out.println("Time Frame unit time is " +ans);
    }

}
