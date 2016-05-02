public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        char[] charArray = s.toCharArray();
        
        while(true){
            while(left < charArray.length && isNotVowels(charArray[left])){
                left++;
            }
            
            while(right >= 0 && isNotVowels(charArray[right])){
                right--; 
            }
            
            if(left >= right){
                break;
            }
            
            char temp = charArray[right];
            charArray[right] = charArray[left];
            charArray[left] = temp;
            right--;
            left++;
        }
        
        return new String(charArray);
    }
    
    public boolean isNotVowels(char ch){
        return !(ch == 'a' || ch == 'e' || ch == 'i' || ch== 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch== 'O' || ch == 'U');
    }
    
    
}