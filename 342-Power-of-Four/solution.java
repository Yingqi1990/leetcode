public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0){
            return false;
        }
        
        int move = 0;
        
        while(num > 0){
             move++;
             
             if((num & 1)== 1){
                 num = num >> 1;
                 break;
             }else{
                 num = num >> 1;
             }
        }
        
        return (num == 0 && move%2 == 1) ? true : false;
    }
}