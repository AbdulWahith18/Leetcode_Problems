# Distinct Subsequences II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string s, return the number of distinct non-empty subsequences of s. Since the answer may be very large, return it modulo 109 + 7.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not.
 
Example 1:

Input: s = "abc"
Output: 7
Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".


Example 2:

Input: s = "aba"
Output: 6
Explanation: The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and "aba".


Example 3:

Input: s = "aaa"
Output: 3
Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".


 
Constraints:


	1 <= s.length <= 2000
	s consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 70.57%)  
**Memory:** 43.6 MB (beats 35.82%)  
**Submitted:** 2026-09-07T01:36:59.422Z  

```java
class Solution {
    public int distinctSubseqII(String s) {

        int MOD = 1000000007;
        int n = s.length();

        long[] dp = new long[n + 1];
        int[] last = new int[26];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            int c = s.charAt(i - 1) - 'a';

            dp[i] = (2 * dp[i - 1]) % MOD;

            if (last[c] != 0) {
                dp[i] = (dp[i] - dp[last[c] - 1] + MOD) % MOD;
            }

            last[c] = i;
        }

        return (int)((dp[n] - 1 + MOD) % MOD);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/distinct-subsequences-ii/)