class Solution {
    public int characterReplacement(String s, int k) {

        int[] chars = new int[26];
        int maxFreq = 0;
        int maxLen = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char currChar = s.charAt(right);

            maxFreq = Math.max(maxFreq, ++chars[currChar - 'A']);

            while((right-left+1) - maxFreq > k ){
                chars[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
        
    }
}
