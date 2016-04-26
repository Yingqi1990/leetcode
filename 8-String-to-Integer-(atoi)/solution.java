public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        
        str = str.trim();
        
        char flag = '+';
        
        int i = 0;
        
        if(str.charAt(0) == '+'){
             i++;
        }else if(str.charAt(0) == '-'){
            flag = '-';
            i++;
        }
        
        double result = 0.0;
        
        for(int cur = i; cur < str.length(); cur++){
            if(str.charAt(cur) >= '0' && str.charAt(cur) <= '9'){
                result = result * 10 + str.charAt(cur) - '0';
            }else{
                break;
            }
        }
        
        if(flag == '-'){
            result = - result;
        }
        
        if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return (int) result;
        }
        
    }
}