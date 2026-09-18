class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] key = new int[26];
            for(char c : str.toCharArray()){
                key[c-'a']++;
            }

            String strkey = Arrays.toString(key);
            map.putIfAbsent(strkey, new ArrayList<>());
            map.get(strkey).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
