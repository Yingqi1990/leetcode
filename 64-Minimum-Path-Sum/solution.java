public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0 ){
            return 0;
        }
        
        int M = grid[0].length;
        int N = grid.length;
        
        int[] res = new int[M];
        res[0] = grid[0][0];
        
        for(int i = 1; i < M; i++){
            res[i] = res[i-1]+grid[0][i];
        }
        
        for(int j = 1; j < N; j++){
            for(int i = 0; i < M; i++){
                if(i==0){
                    res[i] = res[i] + grid[j][i];
                }else{
                    res[i] = Math.min(res[i], res[i-1]) + grid[j][i]; 
                }
            }
        }
        
        return res[M-1];
    }
}