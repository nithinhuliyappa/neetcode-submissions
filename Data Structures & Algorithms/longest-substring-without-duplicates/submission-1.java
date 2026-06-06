class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> IMap = new HashMap<>();
        int start = 0;
        int maxLen = 0;

        for(int end = 0; end < s.length(); end++){

            char c = s.charAt(end);

            if(IMap.containsKey(c)){
                start = Math.max(start, IMap.get(c)+1);
            }
            maxLen = Math.max(maxLen, end-start+1);

            IMap.put(c, end);
        }

        return maxLen;
    }
}
