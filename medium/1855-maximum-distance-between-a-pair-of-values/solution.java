class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {

        int max = 0;

        for (int x = 0; x < nums2.length; x++) {

            int left = 0;
            int right = Math.min(x, nums1.length - 1);

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (nums1[mid] <= nums2[x]) {
                    // Valid, but try to find an even smaller y
                    max = Math.max(max, x - mid);
                    right = mid - 1;
                } else {
                    // nums1[mid] is too large
                    left = mid + 1;
                }
            }
        }

        return max;
    }
}