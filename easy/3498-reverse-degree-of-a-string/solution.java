class Solution {
    public int reverseDegree(String s) {
        int sum=0,n=s.length();
        for(int i=0;i<n;i++)
        {
            int c=26-(s.charAt(i)-'a');
            sum+=(c*(i+1));
        }
        return sum;
    }
}