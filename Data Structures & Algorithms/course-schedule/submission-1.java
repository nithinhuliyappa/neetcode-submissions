class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inOrder = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];

            graph.get(preReq).add(course);
            inOrder[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if(inOrder[i] == 0){
                queue.offer(i);
            }
        }

        int completed = 0;

        while(!queue.isEmpty()){
            int pre = queue.poll();
            completed++;

            for(int course : graph.get(pre)){
                inOrder[course]--;

                if(inOrder[course] == 0){
                    queue.offer(course);
                }
            }
        }

        return completed == numCourses;
    }
}
