class Solution {
    int n;
    
    public boolean isBipartite(int[][] graph) {
        n=graph.length;
        
        for(int i=0;i<n;i++)
        if(!bipartite(i,graph))
        return false;
        return true;
    }

    boolean bipartite(int start,int graph[][])
    {
         int color[]=new int[n];
        Arrays.fill(color,-1);
        color[start]=0;
        Queue<Integer> q1=new LinkedList<>();
        q1.offer(start);
        while(!q1.isEmpty())
        {
            int a=q1.poll();
            for(int b:graph[a])
            if(color[b]==-1)
            {
                color[b]=1-color[a];
                q1.offer(b);
            }
            else if(color[b]==color[a])
            return false;
        }
        return true;
    }


        
    
}