public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return digits;
        }
        
        int len = digits.length;
        int[] reverseNum = new int[len];
        int carry = 0;
        reverseNum[0] = (digits[len - 1] + 1 + carry) % 10;
        carry = (digits[len - 1] + 1 + carry) / 10;
        
        for(int i = len - 2, j = 1; i >= 0; i--, j++){
            reverseNum[j] = (digits[i] +carry) % 10;
            carry = (digits[i] +carry) / 10;
        }
        
        int[] num;
        
        if(carry != 1){
            num = new int[len];
            
            for(int i = 0, j = len - 1; j >= 0; j--, i++){
                 num[j] = reverseNum[i];
            }
            
        }else{
            num = new int[len + 1];
            num[0] = 1;
            
            for(int i = 1, j = len - 1; j >= 0; j--, i++){
                 num[i] = reverseNum[j];
            }
            
        }
      
        return num;
    }
}