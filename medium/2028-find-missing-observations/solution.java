class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int arrSum=0;
        for(int i=0;i<rolls.length;i++)
        {
            arrSum+=rolls[i];
        }
        int missSum=mean*(rolls.length+n)-arrSum;
        if(missSum<=0)
            return new int[0];
        System.out.println(missSum);
        int res[]=new int[n];
        int k=n,j=0;
        int fill=missSum/n;
        while(k>1)
        {
            res[j++]=fill;
            missSum-=fill;
            k--;
        }
        res[j]=missSum;
        if(missSum>6)
            return new int[0];
        return res;
    }
}