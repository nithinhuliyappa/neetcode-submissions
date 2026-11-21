class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] incoming = new int[numCourses];

        for(int i = 0; i<numCourses; i++)
            graph[i] = new ArrayList<>();

        for(int[] prereq : prerequisites){
            int v = prereq[0];
            int u = prereq[1];
            graph[u].add(v);
            incoming[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i<incoming.length; i++){
            if(incoming[i] == 0){
                queue.offer(i);
            }
        }

        int completed = 0;
        while(!queue.isEmpty()){
            int preReq = queue.poll();
            completed++;

            for(int next : graph[preReq]){
                incoming[next]--;

                if(incoming[next] == 0)
                    queue.offer(next);
            }
        }

        return completed == numCourses ? true : false;
    }
}
