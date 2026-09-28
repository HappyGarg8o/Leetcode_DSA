class Solution {
    public void sortColors(int[] nums) {
        int zero = 0; 
        int one = 0;
        int two = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zero++;
            } else if(nums[i] == 1) {
                one++;
            } else {
                two++;
            }
        }
        for(int j = 0; j < zero; j++) {
            nums[j] = 0;
        }
        for(int k = zero; k < zero + one; k++) {
            nums[k] = 1;
        }
        for(int l = zero + one; l < nums.length; l++) {
            nums[l] = 2;
        }
    }
}