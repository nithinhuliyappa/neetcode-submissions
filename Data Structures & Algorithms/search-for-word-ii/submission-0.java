class Solution {
    private Set<String> res;
    private boolean[][] visit;
    
    private class TrieNode  {
        HashMap<Character, TrieNode> children;
        boolean isWord;

        public TrieNode(){
            this.children  = new HashMap<>();
            this.isWord = false;
        }

        public void addWord(String word) {
            TrieNode cur = this;
            for(char c : word.toCharArray()){
                cur.children.putIfAbsent(c, new TrieNode());
                cur = cur.children.get(c);
            }
            cur.isWord = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String word : words) {
            root.addWord(word);
        }

        int ROWS = board.length;
        int COLS = board[0].length;
        visit = new boolean[ROWS][COLS];
        res = new HashSet<>();

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                dfs(board, i, j, root, "");
            }
        }

        return new ArrayList<>(res);
        
    }

    public void dfs(char[][] board, int r, int c, TrieNode node, String word) {

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length 
        || visit[r][c] || !node.children.containsKey(board[r][c]))
            return;

        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if(node.isWord){
            res.add(word);
        }

        dfs(board, r+1, c, node, word);
        dfs(board, r-1, c, node, word);
        dfs(board, r, c+1, node, word);
        dfs(board, r, c-1, node, word);

        visit[r][c] = false;
    }
}
