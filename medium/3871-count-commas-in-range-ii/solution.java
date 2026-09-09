class Solution {
    public long countCommas(long n) {
        long ans = 0;

        // Numbers with 4 to 6 digits → 1 comma
        if (n >= 1000) {
            ans += Math.min(n, 999999) - 999;
        }

        // Numbers with 7 to 9 digits → 2 commas
        if (n >= 1000000) {
            ans += 2 * (Math.min(n, 999999999) - 999999);
        }

        // Numbers with 10 to 12 digits → 3 commas
        if (n >= 1000000000L) {
            ans += 3 * (Math.min(n, 999999999999L) - 999999999);
        }

        // Numbers with 13 to 15 digits → 4 commas
        if (n >= 1000000000000L) {
            ans += 4 * (n - 999999999999L);
        }

        return ans;
    }
}