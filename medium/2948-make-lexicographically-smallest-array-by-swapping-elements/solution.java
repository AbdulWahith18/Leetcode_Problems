class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int i=0,j=1;
        while(j<n)
        {
            if(nums[i]<=nums[j])
            {
                i++;
                j++;
                continue;
