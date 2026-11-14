class PrefixTree {
    TreeNode root;

    public PrefixTree() {
         root = new TreeNode();
    }

    public void insert(String word) {

        TreeNode sentinel = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';

            if(sentinel.children[idx]==null){
                sentinel.children[idx] = new TreeNode();
            }
            sentinel = sentinel.children[idx];
        }
        sentinel.isWord = true;
    }

    public boolean search(String word) {
        TreeNode sentinel = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(sentinel.children[idx]==null)
                return false;
            sentinel = sentinel.children[idx];
        }

        return sentinel.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode sentinel = root;
        for(char ch : prefix.toCharArray()){
            int idx = ch - 'a';
            if(sentinel.children[idx] == null)
                return false;
            sentinel = sentinel.children[idx];
        }
        return true;
    }

    class TreeNode {
        TreeNode[] children;
        boolean isWord;

        public TreeNode(){
            children = new TreeNode[26];
        }
    }
}
