class Solution {
    public int findKthNumber(int n, int k) {
        long start=1;
        k--;
        while(k>0)
        {
            int count=prefixcount(start,n);
            if(k>=count)
            {
                k=k-count;
                start++;
            }else
            {
                start*=10;
                k--;
            }
        }
       return (int)start; 
    }

   int  prefixcount(long start, int n)
    {
        long end=start+1;
        int count=0;
        while(start<=n)
        {
            count+=Math.min(n-start+1,end-start);
            start*=10;
            end*=10;
        }
        return count;
    }
}
