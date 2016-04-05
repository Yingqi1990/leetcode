public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    List<String> res= new ArrayList<String>();
    if(s.length()<10) return res;
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('A',0);
    map.put('C',1);
    map.put('G',2);
    map.put('T',3);
    Set<Integer> temp = new HashSet<Integer>();
    Set<Integer> added = new HashSet<Integer>();
    int hash = 0;
    for(int i=0; i<s.length(); i++){
        if(i<9){
            hash = (hash<<2)+map.get(s.charAt(i));
        }else{
            hash = (hash<<2)+map.get(s.charAt(i));
            hash = hash & ((1<<20)-1);
            if(temp.contains(hash) && !added.contains(hash)){
                res.add(s.substring(i-9,i+1));
                added.add(hash);
            }else{
                temp.add(hash);
            }
        }
    }
    return res;
    }
}