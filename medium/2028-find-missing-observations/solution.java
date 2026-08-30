        int fill=missSum/n;
        int k=n,j=0;
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int arrSum=0;
        for(int i=0;i<rolls.length;i++)
        {
            arrSum+=rolls[i];
        }
        int missSum=mean*(rolls.length+n)-arrSum;
        int res[]=new int[n];
        while(k>1)
        {
            res[j++]=fill;
            k--;
            missSum-=fill;
