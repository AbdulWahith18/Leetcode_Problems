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
**Runtime:** 3 ms (beats 58.06%)  
**Memory:** 46.8 MB (beats 22.58%)  
**Submitted:** 2026-08-27T01:40:36.421Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/)