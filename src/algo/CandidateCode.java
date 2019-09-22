package algo;

/*
    Given a square matrix M[][] containing of 0 and 1, the task is to find a lowest cost Path from (0,0) to any given cell (x,y). You may move in only four direction ie up, down, left and right.
    A path can exists through a cell if and only if it has a value of 1. The cell with value 0 cannot allow a path to go through it. The cost of the path is the number of total cells traversed in the path.
    If we cannot reach the desired cell, then output -1.


    Input Format
    The first line contains N and M, denoting the number of rows and columns repectively.
    Each of the Next N lines Consists of m integers values (0/1).
    The next line contains two integers x and y denoting the Destination Cell.


    Constraints
    0 <= n,m < 1000
    0 <= x,y < 1000


    Output Format
    Output the minimum cost of the path.


    Sample TestCase 1
    Input
    4 4
      1 2 3 4
    1 1 1 1 1
    2 1 0 1 1
    3 0 1 1 1
    4 0 1 1 1
    2 1
    Output
    5
 */

import java.io.*;
import java.util.*;
//TODO Not correct
public class CandidateCode {
    static int n;
    static int m;
    static int[][] mat;
    //static int[][] visited;
    static int x_dest;
    static int y_dest;
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception {
        //Write code here
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        mat = new int[n][m];
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
                visited[i][j] = 0;
            }
        }
        x_dest = scanner.nextInt();
        y_dest = scanner.nextInt();
        if (mat[x_dest][y_dest] == 0) {
            System.out.println(0);
        } else {
            find(0, 0, 0, visited);
            System.out.println(min);
        }
    }

    public static void find(int sum, int x, int y, int[][] visited) {
        if(sum >= min)return;
        visited[x][y] = 1;
        //System.out.println(sum);
        if (found(x, y)) {
            min = sum;
        } else {
            sum++;
            if (isInBound(x + 1, y) && isAllowed(x + 1, y) && !isVisited(visited, x + 1, y))
                find(sum, x + 1, y, visited);
            if (isInBound(x, y + 1) && isAllowed(x, y + 1) && !isVisited(visited, x, y + 1))
                find(sum, x, y + 1, visited);
            if (isInBound(x - 1, y) && isAllowed(x - 1, y) && !isVisited(visited, x - 1, y))
                find(sum, x - 1, y, visited);
            if (isInBound(x, y - 1) && isAllowed(x, y - 1) && !isVisited(visited, x, y - 1))
                find(sum, x, y - 1, visited);
        }
        visited[x][y] = 0;
    }

    public static boolean isAllowed(int x, int y) {
        boolean isAllowed = false;
        if (mat[x][y] != 0) isAllowed = true;
        return isAllowed;
    }

    public static boolean isInBound(int x, int y) {
        boolean isInBound = false;
        if (x >= 0 && x < n && y >= 0 && y < m) isInBound = true;
        return isInBound;
    }

    public static boolean isVisited(int[][] mat, int x, int y) {
        boolean isVisited = false;
        if (mat[x][y] == 1) isVisited = true;
        return isVisited;
    }

    public static boolean found(int x, int y) {
        boolean found = false;
        if (x == x_dest && y == y_dest) found = true;
        return found;
    }
}

