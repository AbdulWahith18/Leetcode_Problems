# Unique 3-Digit Even Numbers

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an array of digits called digits. Your task is to determine the number of distinct three-digit even numbers that can be formed using these digits.

Note: Each copy of a digit can only be used once per number, and there may not be leading zeros.

 
Example 1:


Input: digits = [1,2,3,4]

Output: 12

Explanation: The 12 distinct 3-digit even numbers that can be formed are 124, 132, 134, 142, 214, 234, 312, 314, 324, 342, 412, and 432. Note that 222 cannot be formed because there is only 1 copy of the digit 2.


Example 2:


Input: digits = [0,2,2]

Output: 2

Explanation: The only 3-digit even numbers that can be formed are 202 and 220. Note that the digit 2 can be used twice because it appears twice in the array.


Example 3:


Input: digits = [6,6,6]

Output: 1

Explanation: Only 666 can be formed.


Example 4:


Input: digits = [1,3,5]

Output: 0

Explanation: No even 3-digit numbers can be formed.


 
Constraints:


	3 <= digits.length <= 10
	0 <= digits[i] <= 9

## Solution

**Language:** Java  
**Runtime:** 10 ms (beats 24.00%)  
**Memory:** 43.9 MB (beats 93.07%)  
**Submitted:** 2026-09-11T02:19:41.379Z  

```java
class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        for (int d : digits) {
            freq[d]++;
        }

        int ans = 0;

        for (int num = 100; num <= 999; num++) {

            if (num % 2 != 0)
                continue;

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            freq[a]--;
            freq[b]--;
            freq[c]--;

            if (freq[a] >= 0 && freq[b] >= 0 && freq[c] >= 0) {
                ans++;
            }

            freq[a]++;
            freq[b]++;
            freq[c]++;
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/unique-3-digit-even-numbers/)