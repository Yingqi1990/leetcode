public class Solution {
    public boolean isAnagram(String s, String t) {
      if(s==null && t==null) return true;
      if(s==null || t==null) return false;
      if(s.length()!=t.length()) return false;
      int[] counts = new int[26];
      for(int i=0; i<s.length(); i++){
         counts[s.charAt(i)-'a']++;
         counts[t.charAt(i)-'a']--;
      }
      for(int count : counts){
          if(count!=0) return false;
      }
      return true;
    }
}