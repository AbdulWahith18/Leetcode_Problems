# Count Commas in Range II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer n.

Return the total number of commas used when writing all integers from [1, n] (inclusive) in standard number formatting.

In standard formatting:


	A comma is inserted after every three digits from the right.
	Numbers with fewer than 4 digits contain no commas.


 
Example 1:


Input: n = 1002

Output: 3

Explanation:

The numbers "1,000", "1,001", and "1,002" each contain one comma, giving a total of 3.


Example 2:


Input: n = 998

Output: 0

Explanation:

​​​​​​​All numbers from 1 to 998 have fewer than four digits. Therefore, no commas are used.


 
Constraints:


	1 <= n <= 1015

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 99.36%)  
**Memory:** 42.2 MB (beats 97.44%)  
**Submitted:** 2026-09-09T01:39:09.336Z  

```java
class Solution {
    public long countCommas(long n) {
        long ans = 0;

        // Numbers with 4 to 6 digits → 1 comma
        if (n >= 1000) {
            ans += Math.min(n, 999999) - 999;
        }

        // Numbers with 7 to 9 digits → 2 commas
        if (n >= 1000000) {
            ans += 2 * (Math.min(n, 999999999) - 999999);
        }

        // Numbers with 10 to 12 digits → 3 commas
        if (n >= 1000000000L) {
            ans += 3 * (Math.min(n, 999999999999L) - 999999999);
        }

        // Numbers with 13 to 15 digits → 4 commas
        if (n >= 1000000000000L) {
            ans += 4 * (n - 999999999999L);
        }

        if(n==1000000000000000L)
            return ans+1;
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/count-commas-in-range-ii/)