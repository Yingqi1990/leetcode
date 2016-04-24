public class Solution {
    public String reverseString(String s) {
        if(s == null){
            return null;
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        
        return sb.reverse().toString();
    }
}