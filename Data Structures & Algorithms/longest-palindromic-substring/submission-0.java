class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        
        for(int i = 0; i<s.length(); i++){
 

            int oLen = expand(s, i, i);
            int eLen = expand(s, i, i+1);

            int len = Math.max(oLen, eLen);

            if(len > end-start+1){
                start = i - (len-1)/2;
                end = i + (len/2);
            }
        }

        return s.substring(start, end+1);
    }

    public int expand(String s, int start, int end) {
        while(start >=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start --;
            end ++;
        }

        return end - start -1;
    }
}
