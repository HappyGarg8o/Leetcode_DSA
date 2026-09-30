class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 1;

        for(int num : arr) {
            int prev = num - difference;
            map.put(num, map.getOrDefault(prev, 0) + 1);
            maxLen = Math.max(maxLen, map.get(num));
        }
        return maxLen;
    }
}