class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> s=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!s.containsKey(nums[i]))
                s.put(nums[i],i);
        }
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