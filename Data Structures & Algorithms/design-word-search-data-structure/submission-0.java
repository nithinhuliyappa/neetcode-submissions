class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        public TrieNode(){
            children = new HashMap<>();
            isWord = false;
        }
    }
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int i, TrieNode cur) {
        if(i == word.length())
            return cur.isWord;
        
        char c = word.charAt(i);

        if(c == '.'){
            for(TrieNode child : cur.children.values()){
                if(dfs(word, i+1, child))
                    return true;
            }
            return false;
        }

        if(!cur.children.containsKey(c))
            return false;

        return dfs(word, i+1, cur.children.get(c));
        
    }
}
