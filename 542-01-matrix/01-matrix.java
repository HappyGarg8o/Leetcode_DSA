
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dis = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dis[i], -1);
        }
        int[][] d = { {-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new int[]{i, j, 0});
                    dis[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];

            for(int i = 0; i < 4; i++) {
                int nr = r + d[i][0];
                int nc = c + d[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && dis[nr][nc] == -1) {
                    dis[nr][nc] = t + 1;
                    q.offer(new int[]{nr, nc, t + 1});
                }
            }
        }
        return dis;
    }
}