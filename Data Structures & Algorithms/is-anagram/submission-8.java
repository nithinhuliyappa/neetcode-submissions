class Solution {
    public boolean isAnagram(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        if(sLen != tLen)
            return false;

        int[] map = new int[26];

        for(int i = 0; i < sLen; i++){
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for(int i : map){
            if(i != 0)
                return false;
        }

        return true;
    }
}
