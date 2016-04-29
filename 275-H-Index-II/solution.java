public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        
        int left = 0;
        int right = citations.length - 1;
        int len = citations.length;
        
        int mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            
            if(citations[mid] == len - mid){
                return len - mid;
            }else if(citations[mid] > len - mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            
        }
        
        return len - left;
    }
}