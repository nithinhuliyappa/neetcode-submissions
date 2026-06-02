class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedString = new String(c);
            map.putIfAbsent(sortedString, new ArrayList<String>());
            map.get(sortedString).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
