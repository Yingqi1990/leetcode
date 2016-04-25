public class Solution {
    public boolean isPowerOfTwo(int n) {
        int counter = 0;
        
        while(n > 0){
            counter+= n & 1;
            n = n >> 1; 
        }
        
        return counter == 1 ? true : false;
    }
}