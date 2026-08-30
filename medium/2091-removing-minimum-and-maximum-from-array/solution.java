class Solution {
    public int minimumDeletions(int[] nums) {

        int max = nums[0], min = nums[0];
        int m = 0, n = 0;

        int l = nums.length;

        for (int i = 1; i < l; i++) {

            if (nums[i] > max) {
                max = nums[i];
                m = i;
            }

            if (nums[i] < min) {
                min = nums[i];
                n = i;
            }
        }

        // m = max index
        // n = min index

        int left = Math.min(m, n);
        int right = Math.max(m, n);

        // Both from front
        int front = right + 1;

        // Both from back
        int back = l - left;

        // One from front, one from back
        int mixed = (left + 1) + (l - right);

        return Math.min(front, Math.min(back, mixed));
    }
}