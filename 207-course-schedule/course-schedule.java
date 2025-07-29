class Solution {
    List<List<Integer>> graph=new ArrayList<>();
    int n;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.n=numCourses;

        for(int i=0;i<n;i++)
        graph.add(new ArrayList<>());

        int prevcourse[]=new int[n];

        for(int i=0;i<prerequisites.length;i++)
        {
            int start=prerequisites[i][0];//prerequisite course
            int end=prerequisites[i][1];//course
            graph.get(start).add(end);
            prevcourse[end]++;
        }
        Queue<Integer> q1=new LinkedList<>();
        for(int i=0;i<n;i++)
        if(prevcourse[i]==0)
        q1.offer(i);
        int completedcourse=0;

        while(!q1.isEmpty())
        {
            completedcourse++;
            int a=q1.poll();
            for(int b:graph.get(a))
            {
                prevcourse[b]--;
                if(prevcourse[b]==0)
                q1.offer(b);
            }
        }
        return(completedcourse==n);


    }
}