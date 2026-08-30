class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int arrSum=0;
        for(int i=0;i<rolls.length;i++)
        {
            arrSum+=rolls[i];
        }
        int missSum=mean*(rolls.length+n)-arrSum;
        int res[]=new int[n];
        int k=n,j=0;
        int fill=missSum/n;
