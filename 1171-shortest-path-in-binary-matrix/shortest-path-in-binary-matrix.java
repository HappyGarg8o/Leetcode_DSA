class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        boolean[][] visited = new boolean[n][n];
        Queue <int[]> q = new LinkedList<>();

        int[][] d = {{-1, -1}, {0, 1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {1, 1}, {-1, 1}};

        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dis = curr[2];

            if(r == n - 1 && c == n - 1) return dis;

            for(int i = 0; i < 8; i++) {
                int nr = r + d[i][0];
                int nc = c + d[i][1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && visited[nr][nc] == false) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dis + 1});
                }
            }  
        }
        return -1;
    }
}