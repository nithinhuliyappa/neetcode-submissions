class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sCharArray = s.toCharArray(); //b,b,c,c
        char[] tCharArray = t.toCharArray(); //c,c,b,c

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (Character c : sCharArray){
            if (sMap.containsKey(c)) { 
                sMap.put(c, sMap.get(c)+1); 
            } else {
                sMap.put(c,1); 
            }  
        }
        System.out.println(sMap);

        for (char c : tCharArray){
            if (tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c)+1); 
            } else {
                tMap.put(c,1);
            }
        }
        System.out.println(tMap);

        for (char key : sMap.keySet()){
            if (sMap.get(key).equals(tMap.get(key))) continue;
            return false;
        }

        return true;
    }
}
