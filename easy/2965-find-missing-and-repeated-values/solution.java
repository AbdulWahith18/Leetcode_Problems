class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int m=grid.length;
        Set<Integer> s=new HashSet<>();
        int rep=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(s.contains(grid[i][j]))
                    rep=grid[i][j];
                s.add(grid[i][j]);
            }
        }
        int sum=0;
        for(Integer a:s)
            sum+=a;
        int n=m*m;
        int total=(n*(n+1))/2;
        int New=total-sum;
        return new int[]{rep,New};

    }
}