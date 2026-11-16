class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                //visited and out of bound
                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols || 
                grid[nr][nc] != Integer.MAX_VALUE)
                    continue;

                queue.offer(new int[]{nr, nc});
                grid[nr][nc] = grid[r][c] + 1;
            }

        }
        
    }
}
