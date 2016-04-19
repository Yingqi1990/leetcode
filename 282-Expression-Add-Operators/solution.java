public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        helper(num, target, 0, 0, "", res);
        return res;
    }
    
    public void helper(String num, int target, long curNum, long diff, String sub, List<String> res){
        if((num.length() == 0) && (curNum == target)){
            res.add(sub);
            return;
        }
        
        for(int i = 1; i <= num.length(); i++){
            String str = num.substring(0, i);
            if((str.length() > 1) && (str.charAt(0) == '0')){
                return;
            }
            String next = num.substring(i);
            if(sub.length() == 0){
                helper(next, target, curNum + Long.parseLong(str), Long.parseLong(str), str, res);
            }else{
                helper(next, target, curNum + Long.parseLong(str), Long.parseLong(str), sub + "+" + str, res);
                helper(next, target, curNum - Long.parseLong(str), -Long.parseLong(str), sub + "-" + str, res);
                helper(next, target, (curNum - diff) + diff * Long.parseLong(str), diff * Long.parseLong(str), sub + "*" + str, res);
            }
        }
    }
}