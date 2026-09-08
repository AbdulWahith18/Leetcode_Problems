class Solution {
    public int countCommas(int n) {
        int count=0;
        while(n>0)
        {
            count++;
            n/=10;
        }
    }
        return count/3;
}
