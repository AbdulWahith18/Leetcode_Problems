class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {

        int arrSum = 0;

        for (int x : rolls) {
            arrSum += x;
        }

        int missSum = mean * (rolls.length + n) - arrSum;

        if (missSum < n || missSum > 6 * n)
            return new int[0];

        int[] res = new int[n];

        int fill = missSum / n;
        int rem = missSum % n;

        for (int i = 0; i < n; i++) {

            res[i] = fill;

            if (rem > 0) {
                res[i]++;
                rem--;
            }
        }

        return res;
    }
}