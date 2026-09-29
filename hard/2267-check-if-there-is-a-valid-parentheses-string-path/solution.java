class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int len = m + n - 1;

        // Valid parentheses string must have even length
        if (len % 2 != 0) {
            return false;
        }

        // dp[i][j] = set of possible balances at (i, j)
        boolean[][][] dp = new boolean[m][n][len + 1];

        // Starting cell
        if (grid[0][0] == '(') {
            dp[0][0][1] = true;
        } else {
            return false;
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                int change = (grid[i][j] == '(') ? 1 : -1;

                for (int balance = 0; balance <= len; balance++) {

                    int previousBalance = balance - change;

                    if (previousBalance < 0 || previousBalance > len)
                        continue;

                    // From top
                    if (i > 0 && dp[i - 1][j][previousBalance]) {
                        dp[i][j][balance] = true;
                    }

                    // From left
                    if (j > 0 && dp[i][j - 1][previousBalance]) {
                        dp[i][j][balance] = true;
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}