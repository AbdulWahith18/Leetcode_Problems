class Solution {
    public int factorial(int n)
    {
        int res=1;
        for(int i=2;i<=n;i++)
        {
            res*=i;
        }
        return res;
    }
    public int totalNumbers(int[] digits)
    {
        int disCount=0,count=0;
        Set<Integer> s=new HashSet<>();
        for(int i:digits)
        {
            if(i%2==0)
            {
                count++;
                if(!s.contains(i))
                    disCount++;
                s.add(i);
            }     
        }
        if(count==digits.length)
            return disCount;
        return disCount*factorial(digits.length-1);
    }
}