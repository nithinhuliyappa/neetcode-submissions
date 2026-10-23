class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int islands = 0;
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 
        || row >= grid.length || col >= grid[0].length || grid[row][col] != '1')
            return;

        grid[row][col] = '0';

        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);

        return;
    }
}
