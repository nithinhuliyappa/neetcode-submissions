class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();

        if(edges.length != n-1)
            return false;

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        if(!(dfs(0, -1, graph, visited))){
            return false;
        }

        //Checks graph is not disconnected
        return visited.size() == n;

    }

    public boolean dfs(int vertice, int parent, 
        List<List<Integer>> graph, Set<Integer> visited) {
        
        if(visited.contains(vertice)) {
            return false;
        }

        visited.add(vertice);

        for(int nei : graph.get(vertice)){
            if(nei == parent)
                continue;

            if(!dfs(nei, vertice, graph, visited))
                return false;
        }

        return true;
    }
}
