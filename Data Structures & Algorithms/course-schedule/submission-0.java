class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i<numCourses; i++){
            if(inDegree[i] == 0){
                que.offer(i);
            }
        }

        int count = 0;

        while(!que.isEmpty()){
            int v = que.poll();
            count++;
            for(int n : graph.get(v)){
                inDegree[n]--;

                if(inDegree[n] == 0){
                    que.offer(n);
                }
            }
        }

        return count == numCourses;
        
    }
}
