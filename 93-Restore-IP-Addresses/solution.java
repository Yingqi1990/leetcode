public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null && s.length() == 0){
            return res;
        }
        
        String subset = "";
        helper(res, s, 0, 1, subset);
        
        return res;
    }
    
    public void helper(List<String> res, String s, int index, int segment, String subset){
        if(index >= s.length()){
            return;
        }
        
        if(segment == 4){
            String temp = s.substring(index, s.length());
            if(isValid(temp)){
                res.add(subset + "." + temp);
            }
            
            return;
        }
        
        for(int i = 1; (i <= 4) && (index + i <= s.length()); i++){
            String temp = s.substring(index, index + i);
            if(isValid(temp)){
                if(segment == 1){
                    helper(res, s, index + i, segment + 1, subset + temp);
                }else{
                    helper(res, s, index + i, segment + 1, subset + "." + temp);
                }
            }
        }
        
        return;
    }
    
    public boolean isValid(String temp){
        if(temp == null || temp.length() > 3){
            return false;
        }
        
        if(temp.charAt(0) == '0' && temp.length() > 1){
            return false;
        }
        
        int num = Integer.parseInt(temp);
        
        if(num >=0 && num <= 255){
            return true;
        }
        
        return false;
    }
    
    
    
}