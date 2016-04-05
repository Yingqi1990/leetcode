public class Solution {
     public int maximalRectangle(char[][] matrix){
    	if(matrix==null || matrix.length==0 || matrix[0].length==0){
    		   return 0;
    	}
    	int maxArea = 0;
    	int[] heights= new int[matrix[0].length];
    	for(int i=0; i<matrix.length; i++){
    		for(int j=0; j<matrix[0].length; j++){
    			heights[j] = matrix[i][j]=='0' ? 0 : (heights[j]+1);
    		}
    		maxArea = Math.max(maxArea, largestRectangle(heights));
    	}
    	return maxArea;   
    }
    public int largestRectangle(int[] heights){
    	if(heights==null || heights.length==0) return 0;
    	LinkedList<Integer> stack = new LinkedList<Integer>();
    	int max = 0;
    	for(int i=0; i<heights.length; i++){
    		while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
    			int index = stack.pop();
    			int curMax = stack.isEmpty() ? heights[index]*i: heights[index]*(i-stack.peek()-1);
    			max = Math.max(max, curMax);
    		}
    		stack.push(i);
    	}
    	while(!stack.isEmpty()){
    		int index = stack.pop();
    		int curMax = stack.isEmpty() ? heights[index]*heights.length : heights[index]*(heights.length-stack.peek()-1);
            max = Math.max(max,curMax); 	
    	}
    	return max;
    }
}