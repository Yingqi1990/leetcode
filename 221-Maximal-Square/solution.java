public class Solution {
    public int maximalSquare(char[][] matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        return 0;
    }
    
    int maxValue = 0;
    
    int[][] dp = new int[matrix.length][matrix[0].length];
    
    for(int i = 0; i < matrix[0].length; i++){
         if(matrix[0][i] == '1'){
             dp[0][i] = 1;
             maxValue = 1;
         }
    }
    
    for(int i = 0; i < matrix.length; i++){
        if(matrix[i][0] == '1' ){
        dp[i][0] = 1;
        maxValue = 1;
        }
    }
    
    for(int i = 1; i < matrix.length; i++){
        for(int j =1; j < matrix[0].length; j++){
            dp[i][j] = matrix[i][j] - '0';
            if(dp[i][j] == 1){
               dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
               maxValue = Math.max(dp[i][j], maxValue);
            }
        }
    }
    return maxValue * maxValue;
    }
}