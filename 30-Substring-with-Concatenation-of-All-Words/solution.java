public class Solution {
        public List<Integer> findSubstring(String s, String[] words){
    	List<Integer> res = new ArrayList<Integer>();
    	if(s==null || s.length()==0 || words==null || words.length==0)
    		return res;
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	for(int i=0; i<words.length; i++){
    		String word = words[i];
    		if(map.containsKey(word)){
    			map.put(word, map.get(word)+1);
    		}else{
    			map.put(word, 1);
    		}
    	}
    	for(int i=0; i<words[0].length(); i++){
    		HashMap<String,Integer> curMap = new HashMap<String,Integer>();
    		int count =0;
    		int left = i;
    		for(int j=i; j<=s.length()-words[0].length(); j+=words[0].length()){
    			String str = s.substring(j,j+words[0].length());
    			if(map.containsKey(str)){
    				if(curMap.containsKey(str)){
    					curMap.put(str, curMap.get(str)+1);
    				}else{
    					curMap.put(str,1);
    				}
    				if(curMap.get(str)<=map.get(str)){
    					count++;
    				}else{
    					while(curMap.get(str)>map.get(str)){
    						String temp = s.substring(left,left+words[0].length());
    						curMap.put(temp, curMap.get(temp)-1);
    						if(curMap.get(temp)<map.get(temp)){
    							count--;
    						}
    						left = left+words[0].length();
    					}
    				}
    				if(count==words.length){
    					res.add(left);
    					String temp = s.substring(left, left+words[0].length());
    					curMap.put(temp, curMap.get(temp)-1);
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