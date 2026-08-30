# Kth Missing Positive Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

 
Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.


Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.


 
Constraints:


	1 <= arr.length <= 1000
	1 <= arr[i] <= 1000
	1 <= k <= 1000
	arr[i] < arr[j] for 1 <= i < j <= arr.length


 
Follow up:

Could you solve this problem in less than O(n) complexity?

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.6 MB  
**Submitted:** 2026-08-30T06:35:17.153Z  

```java
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {

        int arrSum = 0;

        for (int x : rolls) {
            arrSum += x;
        }

        int missSum = mean * (rolls.length + n) - arrSum;

        if (missSum < n || missSum > 6 * n)
            return new int[0];

        int[] res = new int[n];

        int fill = missSum / n;
        int rem = missSum % n;

        for (int i = 0; i < n; i++) {

            res[i] = fill;

            if (rem > 0) {
                res[i]++;
                rem--;
            }
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/kth-missing-positive-number/)