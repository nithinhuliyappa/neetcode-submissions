class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            int[]  dic = new int[26];
            for(char c: str.toCharArray()){
                dic[c - 'a']++;
            }
            String key = Arrays.toString(dic);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<> (map.values());
    }
}
