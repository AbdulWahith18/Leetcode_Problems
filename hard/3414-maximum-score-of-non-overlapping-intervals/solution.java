class Solution {
    public int[] maximumWeight(List<List<Integer>> a) {
        int n = a.size();

        Integer[] id = new Integer[n];
        for (int i = 0; i < n; i++) id[i] = i;

        Arrays.sort(id, (i, j) -> a.get(i).get(0) - a.get(j).get(0));

        long[][] dp = new long[n + 1][5];
        List<Integer>[][] res = new ArrayList[n + 1][5];

        // Initialize EVERY state
        for (int i = 0; i <= n; i++)
            for (int k = 0; k <= 4; k++)
                res[i][k] = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {

                // Skip current interval
                dp[i][k] = dp[i + 1][k];
                res[i][k] = new ArrayList<>(res[i + 1][k]);

                // Find first interval with start > current end
                int lo = i + 1, hi = n;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if (a.get(id[mid]).get(0) <= a.get(id[i]).get(1))
                        lo = mid + 1;
                    else
                        hi = mid;
                }

                // Take current interval
                long score = a.get(id[i]).get(2) + dp[lo][k - 1];

                List<Integer> take = new ArrayList<>(res[lo][k - 1]);
                take.add(id[i]);
                Collections.sort(take);

                if (score > dp[i][k] ||
                    score == dp[i][k] && smaller(take, res[i][k])) {

                    dp[i][k] = score;
                    res[i][k] = take;
                }
            }
        }

        return res[0][4].stream().mapToInt(x -> x).toArray();
    }

    boolean smaller(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i)))
                return a.get(i) < b.get(i);
        }
        return a.size() < b.size();
    }
}