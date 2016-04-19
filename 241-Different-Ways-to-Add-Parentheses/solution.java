public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
       List<Integer> res = new ArrayList<Integer>();
       
       if(input == null || input.length() == 0){
           return res;
       }
        
       if(input.length() == 1 && (input.charAt(0) == '*' || input.charAt(0) == '+' || input.charAt(0) == '-')){
           return res;
       }
       
       
       for(int i = 0; i < input.length(); i++){
           char ch = input.charAt(i);
            
           if(ch == '*' || ch == '+' || ch == '-'){
               List<Integer> left = diffWaysToCompute(input.substring(0, i));
               List<Integer> right = diffWaysToCompute(input.substring(i+1));
               for(int t : left){
                   for(int s : right){
                       switch(ch){
                           case '+':
                               res.add(t + s);
                               break;
                               
                           case '-':
                               res.add(t - s);
                               break;
                               
                           case '*':
                              res.add(t * s);
                              break;
                              
                       }
                   }
               }    
               
           }
           
       }
       
       if(res.size() == 0){
           res.add(Integer.parseInt(input));
           return res;
       }
       
       return res;
    }

}