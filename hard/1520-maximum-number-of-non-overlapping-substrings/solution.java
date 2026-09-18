class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        // first[c] = first occurrence of character c
        // last[c]  = last occurrence of character c
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);

        // Find first and last occurrence
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        // Store valid intervals
        List<int[]> intervals = new ArrayList<>();

        // Try creating a valid interval for every character
        for (int c = 0; c < 26; c++) {

            // Character does not exist
            if (first[c] == n) {
                continue;
            }

            int left = first[c];
            int right = last[c];

            boolean valid = true;

            // Expand the interval if necessary
            for (int i = left; i <= right; i++) {

                int x = s.charAt(i) - 'a';

                // This character appeared before our left boundary.
                // Therefore we cannot create a valid substring
                // starting at left.
                if (first[x] < left) {
                    valid = false;
                    break;
                }

                // We must include ALL occurrences of x.
                right = Math.max(right, last[x]);
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // Sort by ending position
        intervals.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        List<String> result = new ArrayList<>();

        int previousEnd = -1;

        // Greedily choose earliest finishing intervals
        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            // Non-overlapping
            if (left > previousEnd) {

                result.add(s.substring(left, right + 1));

                previousEnd = right;
            }
        }

        return result;
    }
}