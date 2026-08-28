class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        if (s.length() == 1)
            return s.compareTo(target) > 0 ? s : "";

        int n = s.length();
        int[] cnt = new int[26];

        for (char ch : s.toCharArray())
            cnt[ch - 'a']++;

        // Check if palindrome is possible
        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1)
            return "";

        // Characters available for left half
        int[] halfCnt = new int[26];

        for (int i = 0; i < 26; i++)
            halfCnt[i] = cnt[i] / 2;

        int m = n / 2;

        StringBuilder left = new StringBuilder();

        // Build left half greedily
        for (int pos = 0; pos < m; pos++) {

            boolean found = false;

            // Try smallest character first
            for (int c = 0; c < 26; c++) {

                if (halfCnt[c] == 0)
                    continue;

                // Take this character
                halfCnt[c]--;
                left.append((char) ('a' + c));

                /*
                 * Put all remaining characters in descending order.
                 * This gives the LARGEST possible palindrome
                 * having the current prefix.
                 */
                StringBuilder temp = new StringBuilder(left);

                for (int x = 25; x >= 0; x--) {
                    for (int k = 0; k < halfCnt[x]; k++) {
                        temp.append((char) ('a' + x));
                    }
                }

                String candidate = makePalindrome(temp, mid);

                if (candidate.compareTo(target) > 0) {
                    // This character is valid.
                    found = true;
                    break;
                }

                // Undo choice
                left.deleteCharAt(left.length() - 1);
                halfCnt[c]++;
            }

            // No character can make the answer > target
            if (!found)
                return "";
        }

        return makePalindrome(left, mid);
    }

    private String makePalindrome(StringBuilder left, char mid) {

        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (mid != 0)
            ans.append(mid);

        for (int i = left.length() - 1; i >= 0; i--)
            ans.append(left.charAt(i));

        return ans.toString();
    }
}