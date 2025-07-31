class Solution {
    int m;
    int arr[];
    int memo[][];
    public int minCost(int n, int[] cuts) {
    m=cuts.length;
    arr=new int[m+2];
    arr[0]=0;
    arr[m+1]=n;
    memo=new int[m+2][m+2];
    
    for(int i=0;i<m+2;i++)
    for(int j=0;j<m+2;j++)
    memo[i][j]=-1;

    for(int i=0;i<m;i++)
    arr[i+1]=cuts[i];
    Arrays.sort(arr);

    return cost(0,m+1);
        
    }

    int cost(int i, int j)
    {
        if(j-i<=1)
        return 0;

        if(memo[i][j]!=-1)
        return memo[i][j];

        int mincost=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++)
        {
          int cost=(arr[j]-arr[i])+cost(i,k)+cost(k,j);
          mincost=Math.min(mincost,cost);
        }
        memo[i][j]=mincost;
        return mincost;
    }
}