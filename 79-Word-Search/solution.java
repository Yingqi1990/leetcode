public class Solution {
    public boolean exist(char[][] board, String word) {
    if(word==null || word.length()==0){
        return true;
    }
    if(board==null || board.length==0 || board[0].length==0){
        return false;
    }
    boolean[][] used = new boolean[board.length][board[0].length];
    for(int i=0; i<board.length; i++ ){
        for(int j=0; j<board[0].length; j++){
            if(search(board, word, i, j, 0, used)){
                return true;
            }
        }
    }
    return false;
    }
    public boolean search(char[][] board, String word, int i, int j, int index, boolean[][] used){
        if(index==word.length()) return true;
        if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || used[i][j] || word.charAt(index)!=board[i][j]) return false;
        used[i][j] = true;
        boolean res = ((search(board, word, i+1, j, index+1, used))||search(board, word, i, j+1, index+1, used) || search(board,word, i-1, j, index+1, used) || search (board, word, i, j-1, index+1, used));
        used[i][j] = false;
        return res;
    }
}