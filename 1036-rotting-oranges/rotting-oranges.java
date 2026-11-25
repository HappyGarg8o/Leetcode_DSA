class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int maxTimer = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i,  j, 0});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            maxTimer = Math.max(maxTimer, t);

            for(int i = 0; i < 4; i++) {
                int nr = r + d[i][0];
                int nc = c + d[i][1];

                if(nr >= 0 && nr < m && nc >= 0&& nc < n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[]{nr, nc, t + 1});
                }
            }
        }
        return fresh == 0 ? maxTimer : -1;
    }
}