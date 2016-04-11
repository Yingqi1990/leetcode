public class Solution {
    public List<String> letterCombinations(String digits){
    	List<String> res = new ArrayList<String>();
    	if(digits == null || digits.length() == 0 ){
    		return res;
    	}
    	String[] buttonNum = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	char[] numArr = digits.toCharArray();
    	StringBuffer sb = new StringBuffer();
    	helper(res, sb, buttonNum, numArr, 0);
    	return res;
    }
    
    public void helper(List<String> res, StringBuffer sb, String[] buttonNum, char[] numArr, int start){
    	if(start == numArr.length){
    		StringBuffer item = new StringBuffer(sb);
    		res.add(item.toString());
    		return;
    	}
    	if(numArr[start] >= '2' && numArr[start] <= '9'){
    		for(int i = 0; i < buttonNum[numArr[start] - '0'].length(); i++){
    			 sb.append(buttonNum[numArr[start] - '0'].charAt(i));
    			 helper(res, sb, buttonNum, numArr, start+1);
    			 sb.deleteCharAt(sb.length()-1);
    		}
    	}else{
    		helper(res, sb, buttonNum, numArr, start+1);
    	}
    	return;
    }
}