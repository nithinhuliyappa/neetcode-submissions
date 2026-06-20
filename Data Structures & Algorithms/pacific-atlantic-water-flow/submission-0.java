class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];

        //pacific
        for(int i=0; i<c; i++){
            dfs(heights, pacific, 0, i, Integer.MIN_VALUE);
        }

        for(int i=0; i<r; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
        }

        //atlantic
        for(int i=0; i<c; i++){
            dfs(heights, atlantic, r-1, i, Integer.MIN_VALUE);
        }

        for(int i=0; i<r; i++){
            dfs(heights, atlantic, i, c-1, Integer.MIN_VALUE);
        }

        List<List<Integer>> res = new ArrayList<>();

        //overlap
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public void dfs(int[][] heights, boolean[][] visited, int r, int c, int pre) {
        if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length
        || visited[r][c] || heights[r][c] < pre)
            return;

        visited[r][c] = true;

        dfs(heights, visited, r+1, c, heights[r][c]);
        dfs(heights, visited, r-1, c, heights[r][c]);
        dfs(heights, visited, r, c+1, heights[r][c]);
        dfs(heights, visited, r, c-1, heights[r][c]);
    }
}
