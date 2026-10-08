class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, arr, k, dp); 
    }
    public int solve(int i, int[] arr, int k, int[] dp) {
        if(i == arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int max_num = -1;
        int len = 0;
        
        for(int j = i; j < arr.length && j < i + k; j++) {
            max_num = Math.max(max_num, arr[j]);
            len = j - i + 1;

            int cost = max_num * len + solve(j + 1, arr, k, dp);
            dp[i] = Math.max(dp[i], cost); 
        }
        return dp[i];
    }
}