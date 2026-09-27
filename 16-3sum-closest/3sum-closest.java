class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int maxDiff = Integer.MAX_VALUE;
        int res = 0;

        for(int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                int diff = Math.abs(sum - target);

                if(diff < maxDiff) {
                    maxDiff = diff;
                    res = sum;
                }

                if(sum == target) {
                    res = sum;
                    return res;
                } 
                else if(sum < target) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }
        return res;
    }
}