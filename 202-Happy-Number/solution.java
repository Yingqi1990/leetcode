public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        while(!set.contains(n)){
            set.add(n);
            int sum = 0;
            
            while(n != 0){
                int temp = n % 10;
                sum+= temp * temp;
                n = n/10;
            }
            
            if(sum == 1){
                return true;
            }
            
            n = sum;
            
        }
        
        return false;
    }
}