class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            int value = num % k;

            // Start a new subarray containing only num
            newDp[value]++;

            // Extend every previous subarray
            for (int r = 0; r < k; r++) {

                int newRemainder = (r * value) % k;

                newDp[newRemainder] += dp[r];
            }

            // Add all subarrays ending at current position
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            // Current subarrays become previous subarrays
            dp = newDp;
        }

        return result;
    }
}