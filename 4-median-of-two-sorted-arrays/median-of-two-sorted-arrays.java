class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mergedarr = new int[m + n];
        int k = 0;

        for (int i = 0; i < m; i++) {
            mergedarr[k++] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            mergedarr[k++] = nums2[i];
        }

        Arrays.sort(mergedarr);

        int len = mergedarr.length;
        if (len % 2 == 1) { 
            return mergedarr[len / 2];
        } else { 
            return (mergedarr[(len / 2) - 1] + mergedarr[len / 2]) / 2.0;
        }
    }
}