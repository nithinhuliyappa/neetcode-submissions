class Solution {
    public int countComponents(int n, int[][] edges) {
        //cycle doesn't matter for connected graph

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int components = 0;

        for(int i = 0 ; i < n; i++) {
            if(!visited[i]){
                components++;
                dfs(i ,graph, visited);
            }
        }

        return components;
    }

    public void dfs(int v, List<List<Integer>> graph, boolean[] visited){
        visited[v] = true;

        for(int nei: graph.get(v)){
            if(!visited[nei]){
                dfs(nei, graph, visited);
            }
        }
    }
}
