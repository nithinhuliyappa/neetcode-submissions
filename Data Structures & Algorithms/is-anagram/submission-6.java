class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int[] freS = new int[26];
        int[] freT = new int[26];

        for(char c : s.toCharArray())
            freS[c - 'a'] = freS[c - 'a'] + 1;

        for(char c : t.toCharArray())
            freT[c - 'a'] = freT[c - 'a']  + 1;

        for(int i = 0 ; i<26; i++){
            if(freS[i] != freT[i])
                return false;
        }
            

        return true; 

    }
}
