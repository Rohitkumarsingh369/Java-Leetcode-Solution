class Solution {
    // This function returns the minimum number of rounds needed to
    // process all tasks in the given array of tasks.
    public int minimumRounds(int[] tasks) {

        // Create a HashMap to store the count of each task
        HashMap<Integer, Integer> getCount = new HashMap<>();

        // Iterate through the tasks array and store the count of each task
        // in the HashMap
        for (int t : tasks) {
            getCount.put(t, getCount.getOrDefault(t, 0) + 1);
        }

        // Initialize a result variable to 0
        int result = 0;

        // Iterate through the values in the HashMap (which represent the counts of the tasks)
        for (int count : getCount.values()) {
            // If a task has a count of 1, it cannot be grouped with other tasks
            // and so we return -1
            if (count == 1) return -1;

            // Add the number of rounds needed to process the tasks with count greater than or equal to 3
            result += count / 3;

            // If there are any tasks left with count less than 3, we need an additional round
            // to process these tasks
            if(count % 3 != 0) result++;
        }

        // Return the total number of rounds needed to process all tasks
        return result;
    }
}