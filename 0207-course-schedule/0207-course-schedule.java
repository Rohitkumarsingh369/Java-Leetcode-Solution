class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Create an adjacency list to represent the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Create an array to keep track of indegree (number of prerequisites)
        int[] indegree = new int[numCourses];

        // Step 3: Populate the adjacency list and indegree array
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);  // Add edge from prereq to course
            indegree[course]++;           // Increment indegree of course
        }

        // Step 4: Add all courses with indegree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 5: Process the courses in the queue
        int processedCourses = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            processedCourses++;

            // For each neighbor (dependent course), reduce its indegree
            for (int neighbor : adj.get(currentCourse)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 6: If all courses were processed, return true; otherwise, return false
        return processedCourses == numCourses;
    }
}