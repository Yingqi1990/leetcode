public class Solution {
    public int largestRectangleArea(int[] heights) {
    if(heights==null || heights.length==0){
        return 0;
    }
    int max = 0;
    LinkedList<Integer> stack = new LinkedList<Integer>(); 
    for(int i=0; i<heights.length; i++){
        while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
            int index = stack.pop();
            int curMax = stack.isEmpty() ? heights[index]*i : heights[index]*(i-stack.peek()-1);
            max = Math.max(curMax, max);
        }
        stack.push(i);
    }
    while(!stack.isEmpty()){
        int index = stack.pop();
        int curMax = stack.isEmpty() ? heights[index]*heights.length: heights[index]*(heights.length-stack.peek()-1);
        max = Math.max(curMax, max);
    }
    return max;
    }
}