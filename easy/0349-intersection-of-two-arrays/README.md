# Intersection of Two Arrays

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]


Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.


 
Constraints:


	1 <= nums1.length, nums2.length <= 1000
	0 <= nums1[i], nums2[i] <= 1000

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.9 MB  
**Submitted:** 2026-08-25T13:20:56.456Z  

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> h1=new HashSet<>();
        HashSet<Integer> h2=new HashSet<>();
        int i=0,j=0;
        int x=nums1.length,y=nums2.length;
        while(i<x&&j<y)
        {
            if(i<x)
                h1.add(nums1[i++]);
            if(j<y)
                h2.add(nums2[j++]);
        }
        List<Integer> l=new ArrayList<>();
        for(int k=0;k<x;k++)
        {
            if(h1.contains(nums1[k])&&h2.contains(nums1[k])&&!l.contains(nums1[k]))
                l.add(nums1[k]);
        }
        int res[] = new int[l.size()];
        for(int k=0;k<l.size();k++)
            res[k]=l.get(k);
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/intersection-of-two-arrays/)