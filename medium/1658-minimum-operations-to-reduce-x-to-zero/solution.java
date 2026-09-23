class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        long total = 0;
        for (int num : nums) {
            total += num;
        }

        long target = total - x;

        // We need to remove everything
        if (target == 0) {
            return n;
        }

        // Impossible
        if (target < 0) {
            return -1;
        }

        int left = 0;
        long sum = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // Shrink window if sum becomes too large
            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            // Found a valid subarray
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        if (maxLen == -1) {
            return -1;
        }

        return n - maxLen;
    }
}