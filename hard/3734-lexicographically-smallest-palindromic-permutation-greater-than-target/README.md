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
**Runtime:** 0 ms  
**Memory:** 42.6 MB  
**Submitted:** 2026-08-28T13:17:41.314Z  

```java
class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int[] cnt = new int[26];
        for (char c : s.toCharArray())
            cnt[c - 'a']++;

        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                odd++;
                mid = (char)('a' + i);
            }
        }

        if (odd > 1) return "";

        int n = s.length(), m = n / 2;

        // Build smallest left half
        char[] half = new char[m];
        int k = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i] / 2; j++)
                half[k++] = (char)('a' + i);
        }

        String ans = make(half, mid);

        if (ans.compareTo(target) > 0)
            return ans;

        // Find next possible half
        for (int pos = m - 1; pos >= 0; pos--) {

            int[] c = cnt.clone();

            // Use characters before pos as they are
            for (int i = 0; i < pos; i++)
                c[half[i] - 'a'] -= 2;

            // Try a bigger character at pos
            for (int x = half[pos] - 'a' + 1; x < 26; x++) {

                if (c[x] >= 2) {

                    c[x] -= 2;

                    char[] h = new char[m];

                    for (int i = 0; i < pos; i++)
                        h[i] = half[i];

                    h[pos] = (char)('a' + x);

                    int p = pos + 1;

                    for (int y = 0; y < 26; y++) {
                        while (c[y] >= 2) {
                            h[p++] = (char)('a' + y);
                            c[y] -= 2;
                        }
                    }

                    ans = make(h, mid);

                    if (ans.compareTo(target) > 0)
                        return ans;
                }

                c = cnt.clone();

                for (int i = 0; i < pos; i++)
                    c[half[i] - 'a'] -= 2;
            }
        }

        return "";
    }

    private String make(char[] h, char mid) {
        StringBuilder s = new StringBuilder(new String(h));
        if (mid != 0) s.append(mid);
        s.append(new StringBuilder(new String(h)).reverse());
        return s.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/)