
class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }

            cur = cur.children[index];
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode cur) {

        // Successfully matched all characters
        if (i == word.length()) {
            return cur.isWord;
        }

        char c = word.charAt(i);

        // Wildcard: explore all possible children
        if (c == '.') {
            for (TrieNode child : cur.children) {
                if (child != null && dfs(word, i + 1, child)) {
                    return true;
                }
            }

            return false;
        }

        // Normal character: follow only one path
        int index = c - 'a';

        if (cur.children[index] == null) {
            return false;
        }

        return dfs(word, i + 1, cur.children[index]);
    }
}
