class Solution {
    public int numRescueBoats(int[] people, int limit) {
          Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int boatsNeeded = 0;
        while (i <= j) {
            int total = people[i] + people[j];
            if (total <= limit) {
                i++;
            }
            j--;
            boatsNeeded++;
        }

        return boatsNeeded;
    }
}