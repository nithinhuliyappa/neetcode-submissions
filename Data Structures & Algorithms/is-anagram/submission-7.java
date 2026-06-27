class Solution {
    public boolean isAnagram(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        if(sLen != tLen)
            return false;

        int[] map = new int[26];

        for(int i = 0; i<sLen; i++){
            int sInd = s.charAt(i) - 'a';
            int tInd = t.charAt(i) - 'a';

            map[sInd]++;
            map[tInd]--;
        }

        for(int i = 0; i<map.length; i++){
            if(map[i]!=0)
                return false;
        }

        return true;

    }
}
