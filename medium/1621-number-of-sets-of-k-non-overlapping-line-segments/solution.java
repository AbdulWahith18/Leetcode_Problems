class Solution {
    public int numberOfSets(int n, int k) {
        final int MOD = 1_000_000_007;

        long[][] dp = new long[k + 1][n];

        // 0 segments -> 1 way
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int segments = 1; segments <= k; segments++) {

            long prefix = 0;

            for (int i = 1; i < n; i++) {

                // dp[segments - 1][0 ... i - 1]
                prefix = (prefix + dp[segments - 1][i - 1]) % MOD;

                // Don't use point i
                dp[segments][i] = dp[segments][i - 1];

                // Add a segment ending at i
                dp[segments][i] =
                    (dp[segments][i] + prefix) % MOD;
            }
        }

        return (int) dp[k][n - 1];
    }
}