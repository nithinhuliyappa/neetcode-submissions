class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int[] ar : memo){
            Arrays.fill(ar , -1);
        }
        return dfs(0, 0, m, n);
    }

    private int dfs(int start, int end, int m, int n) {
        if(start == (m-1) && end == (n-1))
            return 1;

        if(start>=m || end>=n)
            return 0;

        if(memo[start][end] != -1)
            return memo[start][end];

        return memo[start][end] = dfs(start+1, end, m, n) + dfs(start, end+1, m, n);
    }
}
