class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Store the best (rightmost) position where
        // we can make target[i] larger.
        int bestPos = -1;
        int bestChar = -1;

        // We will store the frequency array at every position
        // before consuming target[i].
        int[][] states = new int[n][26];

        for (int i = 0; i < n; i++) {

            // Save available characters before using target[i]
            states[i] = freq.clone();

            int t = target.charAt(i) - 'a';

            // Find smallest available character > target[i]
            for (int c = t + 1; c < 26; c++) {

                if (freq[c] > 0) {
                    bestPos = i;
                    bestChar = c;
                    break;
                }
            }

            // We need target[i] to continue matching
            if (freq[t] == 0) {
                break;
            }

            freq[t]--;
        }

        // No position can make the string greater
        if (bestPos == -1) {
            return "";
        }

        // Reconstruct answer
        StringBuilder ans = new StringBuilder();

        // Prefix same as target
        ans.append(target.substring(0, bestPos));

        // Put smallest possible greater character
        ans.append((char) ('a' + bestChar));

        // Get the frequency state before bestPos
        freq = states[bestPos].clone();

        // Remove the character we just used
        freq[bestChar]--;

        // Fill remaining positions in sorted order
        for (int c = 0; c < 26; c++) {

            while (freq[c] > 0) {
                ans.append((char) ('a' + c));
                freq[c]--;
            }
        }

        return ans.toString();
    }
}