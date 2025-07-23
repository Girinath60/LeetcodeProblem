class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        char[] chararray = num.toCharArray();
        for (char ch : chararray) {
            while (k>0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                
                sb.deleteCharAt(sb.length() - 1);
                k--; 
            }
          
            sb.append(ch);
        }
        while (num.length()!=0 && k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }
        if (idx == sb.length()) {
            return "0";
        }
        String str = sb.toString();
        return sb.substring(idx);

    }
}