class Solution {
    private int ROWS;
    private int COLS;
    
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int r = 0; r<ROWS; r++){
            for(int c = 0; c<COLS; c++){
                if (dfs(board, r, c, word, 0))
                    return true;
            }
        }  
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int i){
        if(i == word.length())
            return true;

        if( r<0 || c<0 || r>=ROWS || c>=COLS 
        || board[r][c]=='#' || board[r][c] != word.charAt(i))
            return false;

        board[r][c] = '#';

        boolean res = dfs(board, r+1, c, word, i+1) ||
                        dfs(board, r-1, c, word, i+1) ||
                        dfs(board, r, c+1, word, i+1) ||
                        dfs(board, r, c-1, word, i+1);

        board[r][c] = word.charAt(i);

        return res;
    }   
}
