class Solution {
    public boolean isNumber(String s) {
        boolean dot = false, eSeen = false, nums = false;
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                nums = true;
            }
            else if(s.charAt(i) == '.'){
                if(dot || eSeen) return false;
                dot = true;
            }
            else if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                if(eSeen || !nums) return false;
                eSeen = true;
                nums = false;
            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') return false;
            }
            else return false;
        }
        return nums;
    }
}