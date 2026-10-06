class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
 
         for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) return false;

        int[][] dp = new int[n + 1][sum + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, sum / 2, 0, dp); 
    }

    public static boolean solve(int[] nums, int sum, int i, int[][] dp) {
        if(i == nums.length) return false;
        if(sum == 0) return true;
        if(dp[i][sum] != -1) return dp[i][sum] == 1;

        boolean take = false;
        if(nums[i] <= sum) {
           take = solve(nums, sum - nums[i], i + 1, dp);
        }
        boolean notTake = solve(nums, sum, i + 1, dp);

        dp[i][sum] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}