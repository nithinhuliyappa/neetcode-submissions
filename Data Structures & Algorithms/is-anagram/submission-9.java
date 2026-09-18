class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if(sLen != tLen)
            return false;
        
        int[] arr = new int[26];

        for(int i = 0; i < sLen; i++){
            int sIdx = s.charAt(i) - 'a';
            int tIdx = t.charAt(i) - 'a';

            arr[sIdx]++;
            arr[tIdx]--;
        }

        for(int val : arr){
            if(val!=0)
                return false;
        }

        return true;

    }
}


