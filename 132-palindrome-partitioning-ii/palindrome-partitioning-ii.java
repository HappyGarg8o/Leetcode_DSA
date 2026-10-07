class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, s, dp) - 1;
    }
    public int solve(int start, String s, int[] dp) {
        if(start == s.length()) return 0;
        if(dp[start] != -1) return dp[start];

        int ans = Integer.MAX_VALUE;
        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end))  {
                ans = Math.min(ans, 1 + solve(end + 1, s, dp));
            }
        }
        return dp[start] = ans;
    }

    boolean isPalindrome(String s, int i, int j) {
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}