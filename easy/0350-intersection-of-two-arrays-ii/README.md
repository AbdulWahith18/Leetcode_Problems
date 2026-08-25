# Intersection of Two Arrays II

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]


Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


 
Constraints:


	1 <= nums1.length, nums2.length <= 1000
	0 <= nums1[i], nums2[i] <= 1000


 
Follow up:


	What if the given array is already sorted? How would you optimize your algorithm?
	What if nums1's size is small compared to nums2's size? Which algorithm is better?
	What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

## Solution

**Language:** Java  
**Runtime:** 16 ms (beats 5.11%)  
**Memory:** 45.1 MB (beats 51.58%)  
**Submitted:** 2026-08-25T13:28:51.372Z  

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> h1=new ArrayList<>();
        List<Integer> h2=new ArrayList<>();
        int i=0,j=0;
        int x=nums1.length,y=nums2.length;
        while(i<x||j<y)
        {
            if(i<x)
                h1.add(nums1[i++]);
            if(j<y)
                h2.add(nums2[j++]);
        }
        List<Integer> l=new ArrayList<>();
        for(int k=0;k<x;k++)
        {
            if(h1.contains(nums1[k])&&h2.contains(nums1[k]))
            {
                l.add(nums1[k]);
                h1.remove(Integer.valueOf(nums1[k]));
                h2.remove(Integer.valueOf(nums1[k]));
            }

        }
        int res[] = new int[l.size()];
        for(int k=0;k<l.size();k++)
            res[k]=l.get(k);
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/intersection-of-two-arrays-ii/)