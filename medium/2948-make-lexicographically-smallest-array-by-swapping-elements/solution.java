class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // int n=nums.length;
        // int i=0;
        // // while(j<n)
        // // {
        // //     if(nums[i]<=nums[j])
        // //     {
        // //         i++;
        // //         j++;
        // //         continue;
        // //     }
        // //     if((nums[i]-nums[j])<=limit)
        // //     {
        // //         int temp=nums[i];
        // //         nums[i]=nums[j];
        // //         nums[j]=temp;
        // //     }
        // //     i++;
        // //     j++;
        // // }
        // while(i<n-1)
        // {
        //     int j=i+1;
        //     int last=j;
        //     while(j<n)
        //     {
        //         if(nums[i]<=nums[j]||(nums[i]-nums[j])>limit)
        //         {
        //             j++;
        //             continue;
        //         }
        //         if((nums[i]-nums[j])<=limit)
        //         {
        //             int temp=nums[i];
        //             nums[i]=nums[j];
        //             nums[j]=temp;
        //             last=j;
        //             j++;
        //         }
        //     }
        //     i=last;
        // }
        // return nums;
                int n = nums.length;

        int i = 0;

        while (i < n - 1) {

            int j = i + 1;
            int last = i;

            while (j < n) {

                // If nums[j] can make position i smaller
                if (nums[j] < nums[i] &&
                    nums[i] - nums[j] <= limit) {

                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                    last = j;
                }

                j++;
            }

            /*
             * If we changed nums[i], start checking again
             * because an even smaller value may now be usable.
             */
            if (last != i) {
                continue;
            }

            i++;
        }

        return nums;
    }
}