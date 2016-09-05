public class Solution {
    public String addBinary(String a, String b) {
        if(a == null && b == null){
            return null;
        }
        
        if(a == null){
            return b;
        }
        
        if(b == null){
            return a; 
        }
        
        String result = "";
        
        if(a.length() < b.length()){
            String tmp = b;
            b = a;
            a = tmp;
        }
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int carry = 0;
        
        while(j >= 0){
            int sum = (int)(a.charAt(i) - '0') + (int)(b.charAt(j) - '0') + carry;
            result = String.valueOf(sum % 2) + result;
            carry = sum / 2;
            i--;
            j--;
        }
        
        while(i >= 0){
            int sum = (int)(a.charAt(i) - '0') + carry;
            result = String.valueOf(sum % 2) + result;
            carry = sum / 2;
            i-- ;
        }
        
        if(carry != 0 ){
            result = "1" + result;
        }
        
        return result;
        
    }
}