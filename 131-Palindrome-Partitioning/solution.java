public class Solution {
    public List<List<String>> partition(String s) {
      List<List<String>> res = new ArrayList<List<String>>();
      if(s == null || s.length() == 0){
          return res;
      }
      List<String> subset = new ArrayList<String>();
      helper(res, subset, s);
      return res;
    }
    
    public void helper(List<List<String>> res, List<String> subset, String s){
        if(s.length() == 0){
            List<String> item = new ArrayList<String>(subset);
            res.add(item);
            return;
        }
        int len = s.length();
        for(int i=1; i<=len; i++){
            String temp = s.substring(0,i);
            if(isPal(temp)){
                subset.add(temp);
                helper(res, subset, s.substring(i, len));
                subset.remove(subset.size()-1);
            }
        }
        return;
    }
    
    public boolean isPal(String temp){
        for(int i = 0, j = temp.length()-1; i<j; i++, j--){
            if(temp.charAt(i) != temp.charAt(j)){
                return false;
            }
        }
        return true;
    }
}