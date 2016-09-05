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
            String tmp = a;
            a = b;
            b = tmp;
        }
        
        int index_a = a.length() - 1;
        int index_b = b.length() - 1;
        int carry = 0;
        
        while(index_b >= 0){
            int sum = (int)(a.charAt(index_a) - '0') + (int)(b.charAt(index_b) - '0') + carry;
            result = String.valueOf(sum % 2) + result;
            carry = sum / 2;
            index_a--;
            index_b--;
        }
        
        while(index_a >=0){
            int sum = (int)(a.charAt(index_a) - '0') + carry;
            result = String.valueOf(sum % 2) + result;
            carry = sum / 2;
            index_a--;
        }
        
        if(carry != 0){
            result = '1' + result;
        }
        
        return result;
    }
}