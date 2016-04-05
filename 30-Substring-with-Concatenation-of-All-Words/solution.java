public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(s==null || s.length()==0 || words==null || words.length==0){
            return res;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<words.length; i++){
            if(map.containsKey(words[i])){
                map.put(words[i], map.get(words[i])+1);
            }else{
                map.put(words[i], 1);
            }
        }
        for(int i=0; i<words[0].length(); i++){
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            int left = i;
            int count = 0;
            for(int j=i; j<=s.length()-words[0].length(); j+=words[0].length()){
                String str = s.substring(j, j+words[0].length());
                if(map.containsKey(str)){
                    if(curMap.containsKey(str)){
                        curMap.put(str, curMap.get(str)+1);
                    }else{
                        curMap.put(str,1);
                    }
                    if(map.get(str)>=curMap.get(str)){
                        count++;
                    }else{
                        while(map.get(str)<curMap.get(str)){
                            String temp = s.substring(left,left+words[0].length());
                            if(map.get(temp)>=curMap.get(temp)){
                                count--;
                            }
                            curMap.put(temp, curMap.get(temp)-1);
                            left+=words[0].length();
                        }
                    }
                    if(count==words.length){
                        res.add(left);
                        String temp = s.substring(left,left+words[0].length());
                        curMap.put(temp,curMap.get(temp)-1);
                        left+= words[0].length();
                        count--;
                    }
                }else{
                     curMap.clear();
                     left = j+words[0].length();
                     count=0;
                }
            }
        }
       return res;
    }
}