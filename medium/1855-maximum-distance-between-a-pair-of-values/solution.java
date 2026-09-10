class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int j=nums2.length-1;
        int i=nums1.length;
        int max=0;
        for(int x=j;x>=0;x--)
        {
            for(int y=0;y<i&&y<=j;y++)
            {
                if(nums1[y]<=nums2[x])
                    max=Math.max(max,(x-y));
            }
        }
        return max;
    }
}