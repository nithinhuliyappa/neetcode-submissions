class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int minute = 0;
        int[][] directions = {{1,0}, {-1,0}, {0, 1}, {0, -1}};

        for(int r = 0 ; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    queue.add(new int[]{r, c});
                }

                if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        
        if(fresh==0)
            return 0;

        while(fresh>0 && !queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i<size; i++){
                int[] start = queue.poll();
                int r = start[0];
                int c = start[1];

                for(int dir = 0; dir < directions.length; dir++){
                    int nr = r + directions[dir][0];
                    int nc = c + directions[dir][1];

                    if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.add(new int[]{nr, nc});
                    }
                }
            } 
            minute++;
        }

        return fresh == 0 ? minute : -1;
        
    }
}
