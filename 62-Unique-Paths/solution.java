public class Solution {
    public int uniquePaths(int m, int n) {
      if(m<=0 || n<=0) return 0;
    	if(m==1|| n==1) return 1;
    	int[] path = new int[n];
    	for(int i=0; i<n; i++){
    		path[i]=1;
    	}
    	for(int i=1; i<m; i++){
    		for(int j=1; j<n; j++){
    			path[j]+=path[j-1];
    		}
    	}
    	return path[n-1];  
    }
}