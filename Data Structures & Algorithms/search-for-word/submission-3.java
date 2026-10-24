class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;


        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0))
                    return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int row, int col, String word, int idx) {
        if(idx == word.length())
            return true;

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length
        || board[row][col] != word.charAt(idx))
            return false;

        char temp = board[row][col];
        board[row][col] = ' ';
        
        boolean res = dfs(board, row+1, col, word, idx+1) ||
        dfs(board, row-1, col, word, idx+1) ||
        dfs(board, row, col+1, word, idx+1) ||
        dfs(board, row, col-1, word, idx+1);

        board[row][col] = temp;

        return res;
    }
}
