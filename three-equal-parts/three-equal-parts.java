import java.util.*;
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;                                                         // Get the length of the array
        List<Integer> indexesOfOnes = new Vector<Integer>();                        // Take a list to store the indexes of ones in the array
        for(int i = 0; i < n; i++){                                                 // Traverse the array and check for ones
            if(arr[i] == 1){                                                        // If the ith index is 1, then add 'i' to the vector
                indexesOfOnes.add(i);
            }
        }
        int numOfOnes = indexesOfOnes.size();                                       // Get the size of the list, i.e., the total no. of 1's
        
        if(numOfOnes%3 != 0)                                                        // If the total no. of 1's is not divisible by 3
            return new int[]{-1, -1};                                               // Then, no 3 equal partition is possible
        
        if(numOfOnes == 0)                                                          // If no 1 is present in the array
            return new int[]{0, n-1};                                               // Then, 3 equal partition of 0's is possible
        
        int indexDist = numOfOnes/3;                                                // Else, get the avg. index distance between the ones
        
        int first  = indexesOfOnes.get(0);                                          // Now, from the list, get the index of the 1st 1 for the 1st partition
        int second = indexesOfOnes.get(indexDist);                                  // Get the index of the 1 at index 'indexDist' for the 2nd partition
        int third  = indexesOfOnes.get(indexDist*2);                                // And get index of the 1 at index '2*indexDist' for the 3rd partition
        
        while(third < n && arr[first] == arr[second] && arr[first] == arr[third]){  // Run a loop while the elements are equal in each part and 'third' is less than 'n'
            first++;                                                                // Keep increasing the value of 'first'
            second++;                                                               // Keep increasing the value of 'second'
            third++;                                                                // And, keep increasing the value of 'third'
        }
        
        if(third == n)                                                              // Check if 'third' has reached the end or not
            return new int[]{first-1, second};                                      // If Yes, then all the partitions were equal; so return 'first-1' & 'second' as the indexes
        
        return new int[]{-1, -1};                                                   // Else, the 3 partitions were not equal; so return {-1, -1}
    }
}
