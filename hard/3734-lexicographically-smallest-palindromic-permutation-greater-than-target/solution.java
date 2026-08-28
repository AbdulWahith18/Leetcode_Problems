class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int[] cnt = new int[26];

        for (char c : s.toCharArray())
            cnt[c - 'a']++;

        // Check whether palindrome is possible
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

        // Build smallest left half
        int m = s.length() / 2;
        char[] half = new char[m];

        int k = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i] / 2; j++) {
                half[k++] = (char) ('a' + i);
            }
        }

        // Smallest palindrome
        String ans = make(half, mid);

        if (ans.compareTo(target) > 0)
            return ans;

        // Find next palindrome
        while (nextPermutation(half)) {

            ans = make(half, mid);

            if (ans.compareTo(target) > 0)
                return ans;
        }

        return "";
    }

    private String make(char[] half, char mid) {

        StringBuilder ans = new StringBuilder();

        ans.append(half);

        if (mid != 0)
            ans.append(mid);

        for (int i = half.length - 1; i >= 0; i--)
            ans.append(half[i]);

        return ans.toString();
    }

    private boolean nextPermutation(char[] a) {

        int i = a.length - 2;

        // Find first decreasing position
        while (i >= 0 && a[i] >= a[i + 1])
            i--;

        if (i < 0)
            return false;

        // Find smallest character greater than a[i]
        int j = a.length - 1;

        while (a[j] <= a[i])
            j--;

        // Swap
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        // Reverse suffix
        int l = i + 1;
        int r = a.length - 1;

        while (l < r) {
            temp = a[l];
            a[l] = a[r];
            a[r] = temp;

            l++;
            r--;
        }

        return true;
    }
}