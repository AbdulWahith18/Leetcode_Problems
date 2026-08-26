class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<nums.length;i++)
            s.add(nums[i]);
        int i=1;
        while(true)
        {
            if(!s.contains(i*k))
                return i*k;
            i++;
        }
    }
}