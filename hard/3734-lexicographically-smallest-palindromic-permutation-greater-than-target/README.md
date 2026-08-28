# Lexicographically Smallest Palindromic Permutation Greater Than Target

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given two strings s and target, each of length n, consisting of lowercase English letters.

Return the lexicographically smallest string that is both a palindromic permutation of s and strictly greater than target. If no such permutation exists, return an empty string.

 
Example 1:


Input: s = "baba", target = "abba"

Output: "baab"

Explanation:


	The palindromic permutations of s (in lexicographical order) are "abba" and "baab".
	The lexicographically smallest permutation that is strictly greater than target is "baab".



Example 2:


Input: s = "baba", target = "bbaa"

Output: ""

Explanation:


	The palindromic permutations of s (in lexicographical order) are "abba" and "baab".
	None of them is lexicographically strictly greater than target. Therefore, the answer is "".



Example 3:


Input: s = "abc", target = "abb"

Output: ""

Explanation:

s has no palindromic permutations. Therefore, the answer is "".


Example 4:


Input: s = "aac", target = "abb"

Output: "aca"

Explanation:


	The only palindromic permutation of s is "aca".
	"aca" is strictly greater than target. Therefore, the answer is "aca".



 
Constraints:


	1 <= n == s.length == target.length <= 300
	s and target consist of only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 133 ms (beats 19.05%)  
**Memory:** 47 MB (beats 57.14%)  
**Submitted:** 2026-08-28T13:21:00.889Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/)