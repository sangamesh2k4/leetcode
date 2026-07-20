class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] distance = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] { i, j });
                    distance[i][j] = 0;
                }
            }
        }
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for (int[] d : dir) {
                int newRow = row + d[0];
                int newCol = col + d[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && distance[newRow][newCol] == -1) {
                    distance[newRow][newCol] = distance[row][col] + 1;
                    q.offer(new int[] { newRow, newCol });
                }
            }
        }
        return distance;
    }
}