class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result=new ArrayList<>();
        Map<String,Integer> reversemap=new HashMap<>();

        for(int i=0;i<words.length;i++)
        reversemap.put(new StringBuilder(words[i]).reverse().toString(),i);

        for(int i=0;i<words.length;i++)
        {
            String word=words[i];
            if(reversemap.containsKey("")&&reversemap.get("")!=i&&pallindrome(word))
            {
                 List<Integer> current=new ArrayList<>();
              current.add(reversemap.get(""));
              current.add(i);
              result.add(current);
            }
            for(int j=0;j<word.length();j++)
            {
            String left=word.substring(0,j);
            String right=word.substring(j);
            if(reversemap.containsKey(left)&&reversemap.get(left)!=i&&pallindrome(right))
            {
               List<Integer> current=new ArrayList<>();
               current.add(i);
               current.add(reversemap.get(left));
               result.add(current);
            }

            if(reversemap.containsKey(right)&&reversemap.get(right)!=i&&pallindrome(left))
            {
              List<Integer> current=new ArrayList<>();
              current.add(reversemap.get(right));
              current.add(i);
              result.add(current);
            }
            }
        }
        return result;
        
    }

    boolean pallindrome(String str)
    {
        int left=0,right=str.length()-1;
        while(left<right)
        {
            if(str.charAt(left)!=str.charAt(right))
            return false;
            left++;right--;
        }
        return true;
    }
}