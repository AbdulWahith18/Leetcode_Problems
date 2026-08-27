# Lexicographically Smallest Permutation Greater Than Target

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two strings s and target, both having length n, consisting of lowercase English letters.

Return the lexicographically smallest permutation of s that is strictly greater than target. If no permutation of s is lexicographically strictly greater than target, return an empty string.

A string a is lexicographically strictly greater than a string b (of the same length) if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b.

 
Example 1:


Input: s = "abc", target = "bba"

Output: "bca"

Explanation:


	The permutations of s (in lexicographical order) are "abc", "acb", "bac", "bca", "cab", and "cba".
	The lexicographically smallest permutation that is strictly greater than target is "bca".



Example 2:


Input: s = "leet", target = "code"

Output: "eelt"

Explanation:


	The permutations of s (in lexicographical order) are "eelt", "eetl", "elet", "elte", "etel", "etle", "leet", "lete", "ltee", "teel", "tele", and "tlee".
	The lexicographically smallest permutation that is strictly greater than target is "eelt".



Example 3:


Input: s = "baba", target = "bbaa"

Output: ""

Explanation:


	The permutations of s (in lexicographical order) are "aabb", "abab", "abba", "baab", "baba", and "bbaa".
	None of them is lexicographically strictly greater than target. Therefore, the answer is "".



 
Constraints:


	1 <= s.length == target.length <= 300
	s and target consist of only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.6 MB  
**Submitted:** 2026-08-27T01:40:30.132Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/)