class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> graph = new HashMap<>();
      Map<Character, Integer> inDegree = new HashMap<>();
      StringBuilder res = new StringBuilder();

      for(String word : words) {
        for(char c: word.toCharArray()){
            graph.putIfAbsent(c, new HashSet<>());
            inDegree.putIfAbsent(c, 0);
        }
      }

      for(int i = 0; i < words.length-1; i++){

        String w1 = words[i];
        String w2 = words[i+1];

        if(w1.length() > w2.length() && w1.startsWith(w2)){
            return "";
        }

        int minLen = Math.min(w1.length(), w2.length());

        for(int j = 0; j<minLen; j++){
            char c1 = w1.charAt(j);
            char c2 = w2.charAt(j);

            if(c1 != c2){
                if(!graph.get(c1).contains(c2)){
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2)+1);
                }
                break;
            }
        }
      }

      Queue<Character> que = new LinkedList<>();

      for(char c : inDegree.keySet()){
        if(inDegree.get(c) == 0){
            que.offer(c);
        }
      }

      while(!que.isEmpty()){
        char c = que.poll();
        res.append(c);

        for(char nei : graph.get(c)){
            inDegree.put(nei, inDegree.get(nei) -1);

            if(inDegree.get(nei) == 0){
                que.offer(nei);
            }
        }
      }

      if(res.length() != inDegree.size())
        return "";

      return res.toString();
    }
}
