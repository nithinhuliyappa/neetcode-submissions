class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dic = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int res = 0;

        if(!dic.contains(endWord) || beginWord.equals(endWord))
            return res;

        while(!queue.isEmpty()){
            res++;
            for(int i = queue.size(); i>0; i--){
                String word = queue.poll();
                if(word.equals(endWord)) return res;
                for (int j = 0; j<word.length(); j++){
                    for(char c = 'a'; c<='z'; c++){
                        if(c == word.charAt(j)) continue;
                        
                        String nei = word.substring(0, j) + c + word.substring(j+1);
                        
                        if(dic.contains(nei)){
                            dic.remove(nei);
                            queue.offer(nei);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
