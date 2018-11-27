package com.shalaka;

public class NumberOfIslands {
    int count;
    boolean[][] marked;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!marked[i][j]) {
                    boolean island = dfs(i, j, m, n, grid);
                    if (island)
                        count++;
                }
            }
        }

        return count;
    }

    private boolean dfs(int i, int j, int m, int n, char[][] grid) {
        marked[i][j] = true;
        if (grid[i][j] == '1' && j + 1 < n && !marked[i][j + 1]) {
            dfs(i, j + 1, m, n, grid);
        }
        if (grid[i][j] == '1' && i + 1 < m && !marked[i + 1][j]) {
            dfs(i + 1, j, m, n, grid);
        }
        if (grid[i][j] == '1' && i - 1 >= 0 && !marked[i - 1][j]) {
            dfs(i - 1, j, m, n, grid);
        }
        if (grid[i][j] == '1' && j - 1 >= 0 && !marked[i][j - 1]) {
            dfs(i, j - 1, m, n, grid);
        }

        return grid[i][j] == '1';
    }

    public static void main(String args[]) {
//        char[][] grid = new char[][]{
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};
//        char[][] grid = new char[][]{
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}};

        char[][] grid = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}};
        NumberOfIslands n = new NumberOfIslands();
        System.out.println(n.numIslands(grid));
    }
}
