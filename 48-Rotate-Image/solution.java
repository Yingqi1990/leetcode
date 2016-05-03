public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        
        int n = matrix.length;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length - i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 -j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }
        
        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
    }
}