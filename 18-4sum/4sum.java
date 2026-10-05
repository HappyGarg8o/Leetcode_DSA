class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
         List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 3; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                int left = j + 1, right = n - 1;

                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));

                        left++;
                        right--;

                        while (left < right && arr[left] == arr[left - 1]) left++;
                        while (left < right && arr[right] == arr[right + 1]) right--;

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
                // j++;
                // while(j < n && arr[j] == arr[j - 1]) j++;
            }
        }
        return result;
    }
}