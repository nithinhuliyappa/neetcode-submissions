class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inOrder = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int completed = 0;
        int[] res = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<prerequisites.length; i++){
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];

            graph.get(preReq).add(course);
            inOrder[course]++;
        }

        for(int i = 0; i<numCourses; i++){
            if(inOrder[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int preReq = queue.poll();
            res[completed++] = preReq;

            for(int course : graph.get(preReq)){
                inOrder[course]--;
                if(inOrder[course] == 0){
                    queue.offer(course);
                }
            }
        }

        if(completed == numCourses){
            return res;
        }

        return new int[]{};

    }
}
