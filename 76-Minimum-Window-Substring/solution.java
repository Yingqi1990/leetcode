public class Solution {
    public String minWindow(String s, String t) {
    if(s==null || s.length()==0) return "";
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for(int i=0; i<t.length(); i++){
        if(map.containsKey(t.charAt(i))){
            map.put(t.charAt(i), map.get(t.charAt(i))+1);
        }else{
            map.put(t.charAt(i), 1);
        }
    }
    int len = s.length();
    int minLen = len+1;
    int left=0;
    int count=0;
    int minStart=0;
    for(int right=0; right<s.length(); right++){
        if(map.containsKey(s.charAt(right))){
            map.put(s.charAt(right),map.get(s.charAt(right))-1);
            if(map.get(s.charAt(right))>=0) count++;
            while(count==t.length()){
                if(right-left+1<minLen){
                    minStart = left;
                    minLen = right-left+1;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left))>0) count--;
                }
                left++;
            }
        }
    }
    if(minLen>s.length()) return "";
    return s.substring(minStart, minStart+minLen);
    }
}