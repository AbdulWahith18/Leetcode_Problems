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