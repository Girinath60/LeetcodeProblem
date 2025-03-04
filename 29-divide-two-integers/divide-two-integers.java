class Solution {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
    
        boolean sign = (a < 0) == (b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        
        int res = 0;
        while (a - b >= 0) {
            int x = b, count = 1;
            
            while (a - (x << 1) >= 0) {
                x <<= 1;
                count <<= 1;
            }
            
            a -= x;
            res += count;
        }
        
        return sign ? res : -res;
    }
}