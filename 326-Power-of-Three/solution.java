public class Solution {
    
    private static final double eps = 10e-15;
    
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        
        double res = Math.log(n) / Math.log(3);
        
        return Math.abs(Math.round(res) - res) < eps;
        
    }
}