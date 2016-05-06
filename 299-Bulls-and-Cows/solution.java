public class Solution {
    public String getHint(String secret, String guess) {
         if(secret == null || guess == null || secret.length() == 0 || guess.length() ==0 ){
             return secret;
         }
         
         int bull = 0;
         int cow = 0;
         HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
         HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
         
         for(int i = 0; i < secret.length(); i++){
             if(guess.charAt(i) == secret.charAt(i)){
                 bull++;
             }else{
                 if(map1.containsKey(secret.charAt(i))){
                     map1.put(secret.charAt(i), map1.get(secret.charAt(i)) + 1);
                 }else{
                     map1.put(secret.charAt(i), 1);
                 }
                 
                 if(map2.containsKey(guess.charAt(i))){
                     map2.put(guess.charAt(i), map2.get(guess.charAt(i)) + 1);
                 }else{
                     map2.put(guess.charAt(i), 1);
                 }
       
             }
         }
         
         for(int i = 0; i < secret.length(); i++){
             if(map1.containsKey(secret.charAt(i)) && map2.containsKey(secret.charAt(i))){
                 cow = cow + Math.min(map1.get(secret.charAt(i)), map2.get(secret.charAt(i)));
                 map1.put(secret.charAt(i), 0);
                 map2.put(secret.charAt(i), 0);
             }
         }
         
         String res = bull + "A" + cow + "B";
         
         return res;
         
    }
}