public class Solution {
    public int findKthLargest(int[] nums, int k) {
          if(nums == null){
              return -1;
          }
          
          if(k<=0){
              return -1;
          }
          
          if(nums.length < k){
              return -1; 
          }
          
          PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
          
          for(int i = 0; i < nums.length; i++){
              pq.add(nums[i]);
              if(pq.size() > k){
                  pq.poll();
              }
          }
          return pq.poll();
    }
}