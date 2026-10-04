class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;

        int[] prefix = new int[n];
        prefix[0] = gain[0];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + gain[i];
        }

        int max = 0;
        for(int j = 0; j < n; j++) {
            if(max < prefix[j]) {
                max = prefix[j];
            }
        }
        return max;
    }
}