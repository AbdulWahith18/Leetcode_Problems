class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];

        for (int i = 0; i < n; i++) {

            int t = target.charAt(i) - 'a';

            // First, try to keep target[i] equal
            if (freq[t] > 0) {

                ans[i] = target.charAt(i);
                freq[t]--;

            } else {

                // Cannot keep equality.
                // Find smallest character greater than target[i].
                int bigger = -1;

                for (int c = t + 1; c < 26; c++) {
                    if (freq[c] > 0) {
                        bigger = c;
                        break;
                    }
                }

                if (bigger != -1) {

                    ans[i] = (char) ('a' + bigger);
                    freq[bigger]--;

                    // Fill remaining characters in sorted order
                    int pos = i + 1;

                    for (int c = 0; c < 26; c++) {
                        while (freq[c] > 0) {
                            ans[pos++] = (char) ('a' + c);
                            freq[c]--;
                        }
                    }

                    return new String(ans);
                }

                /*
                 * We cannot continue matching target.
                 * Need to backtrack.
                 */
                break;
            }
        }

        // target prefix may need to be changed.
        // Rebuild frequencies.
        freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Try changing target from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Use target[0 ... i-1]
            for (int j = 0; j < i; j++) {
                freq[target.charAt(j) - 'a']--;
            }

            int t = target.charAt(i) - 'a';

            // Find smallest available character > target[i]
            for (int c = t + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    ans = new char[n];

                    // Prefix
                    for (int j = 0; j < i; j++) {
                        ans[j] = target.charAt(j);
                    }

                    ans[i] = (char) ('a' + c);
                    freq[c]--;

                    int pos = i + 1;

                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            ans[pos++] = (char) ('a' + x);
                            freq[x]--;
                        }
                    }

                    return new String(ans);
                }
            }

            // Restore target[i]
            freq[t]++;
        }

        return "";
    }
}