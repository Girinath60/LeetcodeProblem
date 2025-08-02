class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int fresh=0;
        Queue<int []> q1=new LinkedList<>();

        for(int  i=0;i<row;i++)
        for(int j=0;j<col;j++)
        if(grid[i][j]==2)
        q1.offer(new int[]{i,j});
        else if(grid[i][j]==1)
        fresh++;

        int direction[][]={{1,0},{-1,0},{0,1},{0,-1}};
        int time=0;
        while(!q1.isEmpty()&&fresh>0)
        {
            time++;
            int siz=q1.size();
            for(int i=0;i<siz;i++)
            {
            int position[]=q1.poll();
            for(int k=0;k<4;k++)
            {
                int x=position[0]+direction[k][0];
                int y=position[1]+direction[k][1];
                if(x>=0&&y>=0&&x<row&&y<col&&grid[x][y]==1)
                {
                    grid[x][y]=2;
                    fresh--;
                    q1.offer(new int[]{x,y});
                }
            }

            }
        }
        if(fresh==0)
        return time;
        else
        return -1;
        
    }
}