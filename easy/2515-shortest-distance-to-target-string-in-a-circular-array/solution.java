class Solution {
    public int minMirrorPairDistance(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            int temp = nums[i];
            int reverse = 0;

            while (temp != 0) {
                reverse = reverse * 10 + temp % 10;
                temp /= 10;
            }

            if (map.containsKey(reverse)) {
                res = Math.min(res, map.get(reverse) - i);
            }

            // Store this number as a possible nums[j]
            map.put(nums[i], i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}