class Solution {
    public int stoneGameVIII(int[] s) {
        int n = s.length;

        // Calculate prefix sums
        int[] prefix = new int[n];
        prefix[0] = s[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + s[i];
        }
        for(int i:prefix)
            System.out.print(i+" ");
        // Initially, consider taking all stones
        int ans = prefix[n - 1];
        System.out.println();
        // Try every possible point where the game can be split
        for (int i = n - 2; i >= 1; i--) {
            System.out.println(ans+" "+(prefix[i]-ans));
            ans = Math.max(ans, prefix[i] - ans);
        }

        return ans;
    }
}