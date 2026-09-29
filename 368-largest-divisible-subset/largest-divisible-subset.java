public class Solution {
    public static List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;

        int[] dp = new int[n];
        int[] parent = new int[n];

        int maxLength = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = i;

            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    parent[i] = j;
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> res = new ArrayList<>();

        while (parent[lastIndex] != lastIndex) {
            res.add(arr[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        res.add(arr[lastIndex]);

        Collections.reverse(res);

        return res;
    }
}