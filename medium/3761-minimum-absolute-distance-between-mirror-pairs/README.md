# Minimum Absolute Distance Between Mirror Pairs

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array nums.

A mirror pair is a pair of indices (i, j) such that:


	0 <= i < j < nums.length, and
	reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by reversing the digits of x. Leading zeros are omitted after reversing, for example reverse(120) = 21.


Return the minimum absolute distance between the indices of any mirror pair. The absolute distance between indices i and j is abs(i - j).

If no mirror pair exists, return -1.

 
Example 1:


Input: nums = [12,21,45,33,54]

Output: 1

Explanation:

The mirror pairs are:


	(0, 1) since reverse(nums[0]) = reverse(12) = 21 = nums[1], giving an absolute distance abs(0 - 1) = 1.
	(2, 4) since reverse(nums[2]) = reverse(45) = 54 = nums[4], giving an absolute distance abs(2 - 4) = 2.


The minimum absolute distance among all pairs is 1.


Example 2:


Input: nums = [120,21]

Output: 1

Explanation:

There is only one mirror pair (0, 1) since reverse(nums[0]) = reverse(120) = 21 = nums[1].

The minimum absolute distance is 1.


Example 3:


Input: nums = [21,120]

Output: -1

Explanation:

There are no mirror pairs in the array.


 
Constraints:


	1 <= nums.length <= 105
	1 <= nums[i] <= 109​​​​​​​

## Solution

**Language:** Java  
**Runtime:** 7 ms  
**Memory:** 52.3 MB  
**Submitted:** 2026-09-10T13:10:09.799Z  

```java
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> s=new HashMap<>();
        for(int i=0;i<nums.length;i++)
            s.put(nums[i],i);
        int res=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int reverse = 0;

            while (nums[i] != 0) 
            {
            reverse = reverse * 10 + (nums[i] % 10);
            nums[i] = nums[i] / 10;
            }
            if(s.containsKey(reverse)&&i<s.get(reverse))
                res=Math.min(res,Math.abs(i-s.get(reverse)));
        }
        if(res==Integer.MAX_VALUE)
            return -1;
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/)