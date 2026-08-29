import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // Store value + original index
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;

        while (i < n) {

            int j = i + 1;

            // Find all elements belonging to this group
            while (j < n &&
                   arr[j][0] - arr[j - 1][0] <= limit) {
                j++;
            }

            // Collect original indices
            int[] pos = new int[j - i];

            for (int k = i; k < j; k++) {
                pos[k - i] = arr[k][1];
            }

            // Smallest original index first
            Arrays.sort(pos);

            // Put smallest values at smallest positions
            for (int k = i; k < j; k++) {
                nums[pos[k - i]] = arr[k][0];
            }

            i = j;
        }

        return nums;
    }
}