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
**Runtime:** 1 ms  
**Memory:** 42.6 MB  
**Submitted:** 2026-08-28T13:06:45.884Z  

```java
class Solution { 
    public String lexPalindromicPermutation(String s, String target) { 

        int[] counts = new int[26]; 

        for (char c : s.toCharArray()) { 
            counts[c - 'a']++; 
        } 

        int oddCount = 0; 
        char oddChar = 0; 

        for (int i = 0; i < 26; i++) { 
            if (counts[i] % 2 != 0) { 
                oddCount++; 
                oddChar = (char) (i + 'a'); 
            } 
        }

        if (oddCount > 1)
            return "";

        char[] st = new char[s.length()];

        int k = 0;
        int j = s.length() - 1;

        for (int i = 25; i >= 0; i--) {

            if (counts[i] > 0 && counts[i] % 2 == 0) {

                int c = counts[i] / 2;

                while (c > 0) {

                    st[k++] = (char) (i + 'a');
                    st[j--] = (char) (i + 'a');

                    c--;
                }
            }
        }

        if (k == j && oddCount == 1) {
            st[k] = oddChar;
        }

        String rev = new String(st);

        int com = rev.compareTo(target);

        System.out.println("str " + rev);
        System.out.println("COM " + com);

        if (com > 0)
            return rev;

        return "";
    } 
}
```

---

[View on LeetCode](https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/)