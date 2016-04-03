public class Solution {
    public boolean wordPattern(String pattern, String str) {
      String[] strs = str.split(" ");
      if(pattern.length() != strs.length) return false;
      HashMap<Character, String> map = new HashMap<Character, String>();
      for(int i=0; i<pattern.length(); i++){
          if(map.containsKey(pattern.charAt(i))){
              if(strs[i].equals(map.get(pattern.charAt(i)))){
                  continue;
              }else{
                  return false;
              }
          }else{
              if(map.containsValue(strs[i])){
                  return false;
              }else{
                  map.put(pattern.charAt(i), strs[i]);
              }
          }
      }
      return true;
    }
}