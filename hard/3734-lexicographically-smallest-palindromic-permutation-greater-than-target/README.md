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
**Memory:** 43 MB  
**Submitted:** 2026-08-28T13:16:58.144Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/)