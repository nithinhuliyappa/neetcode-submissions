class Solution {
    public String minWindow(String s, String t) {

        if(t.isEmpty()) return "";

        Map<Character, Integer> freT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        for(char c : t.toCharArray()){
            freT.put(c, freT.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = freT.size();
        int[] res = {-1, -1};
        int l = 0 ;
        int resLen = Integer.MAX_VALUE;

        for(int r = 0; r < s.length(); r++){

            char curC = s.charAt(r);
            window.put(curC, window.getOrDefault(curC, 0) + 1);

            if(freT.containsKey(curC) && freT.get(curC).equals(window.get(curC)))
                have++;
            
            while(have == need){
                if(r-l+1 < resLen){
                    resLen = Math.min(r-l+1, resLen);
                    res[0] = l;
                    res[1] = r;
                }

                char leftC = s.charAt(l);
                window.put(leftC, window.get(leftC) - 1);
                if(freT.containsKey(leftC) && window.get(leftC) < freT.get(leftC))
                    have--;
                
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "":s.substring(res[0], res[1]+1);        
    }
}
