class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;

        int[] arr = new int[len + 2];
        Arrays.sort(cuts);
        arr[0] = 0;
        arr[len + 1] = n;
        for(int i = 0; i < len; i++) {
            arr[i + 1] = cuts[i];
        }
        int[][] dp = new int[len + 2][len + 2];
        for(int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, len + 1, arr, dp);
    }
    public int solve(int i, int j, int[] arr,int[][] dp) {
        if(i == j - 1 || i + 1 == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k++) {
            int cost = arr[j] - arr[i];
            int left = solve(i, k, arr, dp);
            int right = solve(k, j, arr, dp);
            minCost = Math.min(minCost, cost + left + right);
        }
        return dp[i][j] = minCost;
    }
}