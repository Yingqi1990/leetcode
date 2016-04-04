public class Solution {
    public boolean isValidSudoku(char[][] board) {
     if(board==null || board.length!=9 || board[0].length!=9){
    		return false;
    	}
    	for(int i=0; i<board.length; i++){
    		boolean[] check = new boolean[9];
    		for(int j=0; j<board[0].length; j++){
    	      if(board[i][j]!='.'){
    			if(check[(int)(board[i][j]-'1')]){
    				return false;
    			}else{
    				check[(int)(board[i][j]-'1')]=true;
    			}
    		  }
    		}
    	}
    	for(int j=0; j<board[0].length; j++){
    	   boolean[] check = new boolean[9];
    	   for(int i=0; i<board.length; i++){
    		   if(board[i][j]!='.'){
    			   if(check[(int)(board[i][j]-'1')]){
    				   return false;
    			   }else{
    				   check[(int)(board[i][j]-'1')]=true;
    			   }
    		   }
    	   }
    	}
    	for(int boardNum =0; boardNum< 9; boardNum++){
    		boolean[] check = new boolean[9];
    		for(int i=boardNum/3*3; i<boardNum/3*3+3; i++){
    			for(int j=boardNum%3*3; j<boardNum%3*3+3; j++){
    				if(board[i][j]!='.'){
    					if(check[(int)(board[i][j]-'1')]){
    						return false;
    					}else{
    						check[(int)(board[i][j]-'1')]=true;
    					}
    				}
    			}
    		}
    		
    	}
    	return true;   
    }
}