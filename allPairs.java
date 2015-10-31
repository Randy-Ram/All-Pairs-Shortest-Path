import java.util.*;
import java.io.*;

public class allPairs
{
    private static int adjMatrix[][] = new int[6][6];
    private static int pi[][] = new int[6][6];
    private static int values[] = {0, 3, 8, 9999, -4, 
                                   9999, 0, 9999, 1, 7,
                                   9999, 4, 0, 9999, 9999,
                                   2, 9999, -5, 0, 9999,
                                   9999, 9999, 9999, 6, 0};
    
    private static int predecessors[] = {0, 1, 1, 9999, 1, 
                                        9999, 0, 9999, 2, 2,
                                        9999, 3, 0, 9999, 9999,
                                        4, 9999, 4, 0, 9999,
                                        9999, 9999, 9999, 5, 0};
    
    public static void main(String[] args)
    {
        int val = 0;
        for(int i = 1; i < 6; i++)
        {
            for(int j = 1; j < 6; j++)
            {
                adjMatrix[i][j] = values[val];
                pi[i][j] = predecessors[val];
                val++;
            }
        }
        
        printArray(pi);
        System.out.println("");
        calcBestPaths(adjMatrix, 5, pi);
    }
    
    private static void printArray(int[][] arr)
    {
        for(int i = 1; i < 6; i++)
        {
            for(int j = 1; j < 6; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    
    private static void calcBestPaths(int[][] arr, int numNodes, int[][] pi)
    {
        for(int k = 1; k <= numNodes; k++)
        {
            for(int i = 1; i <= numNodes; i++)
            {
                for(int j = 1; j <= numNodes; j++)
                {
                    if(i == j)
                    {
                        continue;
                    }
                    else
                    {
                     
                        int cost1 = arr[i][j];
                        int cost2 = arr[i][k] + arr[k][j];
                        if (cost1 < cost2)
                        {
                            arr[i][j] = cost1;
                        }
                        else
                        {
                            arr[i][j] = cost2;
                            if(cost2 < 9999)
                            {
                                pi[i][j] = k;
                            }
                        }     
                    }
                    
                }
            }
            System.out.println("k = " + k);
            printArray(pi);
            System.out.println("");
        }
    }
}