class Solution {
    int row,col;
    int dun[][];
    int memo[][];
    public int calculateMinimumHP(int[][] dungeon) {
        row=dungeon.length;
        col=dungeon[0].length;
        dun=dungeon;
        memo=new int[row+1][col+1];
        return game(0,0);
        
    }
    int game(int i, int j)
    {
        if(i>=row||j>=col)
        return Integer.MAX_VALUE;

        if(memo[i][j]!=0)
        return memo[i][j];
        
        if(i==row-1&&j==col-1)
        return Math.max(1,1-dun[i][j]);

        int left=game(i,j+1);
        int right=game(i+1,j);

       int d= Math.min(left,right)-dun[i][j];
       memo[i][j]=Math.max(1,d);
       return Math.max(1,d);
    }
}