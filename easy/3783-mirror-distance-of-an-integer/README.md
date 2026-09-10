# Mirror Distance of an Integer

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an integer n.

Define its mirror distance as: abs(n - reverse(n))​​​​​​​ where reverse(n) is the integer formed by reversing the digits of n.

Return an integer denoting the mirror distance of n​​​​​​​.

abs(x) denotes the absolute value of x.

 
Example 1:


Input: n = 25

Output: 27

Explanation:


	reverse(25) = 52.
	Thus, the answer is abs(25 - 52) = 27.



Example 2:


Input: n = 10

Output: 9

Explanation:


	reverse(10) = 01 which is 1.
	Thus, the answer is abs(10 - 1) = 9.



Example 3:


Input: n = 7

Output: 0

Explanation:


	reverse(7) = 7.
	Thus, the answer is abs(7 - 7) = 0.



 
Constraints:


	1 <= n <= 109

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.3 MB  
**Submitted:** 2026-09-10T12:26:53.532Z  

```java
class Solution {
    public int mirrorDistance(int num) {
        int reverse = 0,x=num;

        while (num != 0)
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }
    }
        {
        return Math.abs(x-reverse);
}

```

---

[View on LeetCode](https://leetcode.com/problems/mirror-distance-of-an-integer/)