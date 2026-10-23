class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int maxArea = 0;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
        || grid[row][col] != 1)
            return 0;

        int area = 1;
        grid[row][col] = 0;

        area += dfs(grid, row+1, col);
        area += dfs(grid, row-1, col);
        area += dfs(grid, row, col+1);
        area += dfs(grid, row, col-1);

        return area;
    }
}
