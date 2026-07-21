class Solution {
    int dfs(int row, int col, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1 + dfs(row - 1, col, grid) + dfs(row + 1, col, grid) +
                dfs(row, col - 1, grid) + dfs(row, col + 1, grid);

    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxarea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid);
                    maxarea = Math.max(maxarea,area);
                }
            }
        }
        return maxarea;
    }
}