public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0) return 0;
       int m = obstacleGrid.length;
       int n = obstacleGrid[0].length;
       int[] path = new int[n];
       int r;
       for(r=0; r<n; r++){
    	   if(obstacleGrid[0][r]==1){
              path[r]=0;
              break;
    	   }
    	   path[r]=1;
       }
       for(;r<n;r++){
    	   path[r]=0;
       }
       for(int i=1; i<m; i++){
    	   if (obstacleGrid[i][0]==1) path[0]=0;
    	   for(int j=1; j<n; j++){
    		   if(obstacleGrid[i][j]==1){ 
    			   path[j]=0;
    			   continue;
    		   }
    		   path[j]+=path[j-1];
    	   }
       }
       return path[n-1];    
    }
}