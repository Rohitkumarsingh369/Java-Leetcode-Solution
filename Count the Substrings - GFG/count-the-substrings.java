//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    public static int countSubstring(String S) {
    int count = 0;
    // Initialize a HashMap to keep track of the number of substrings with a given difference
    // between the count of uppercase and lowercase letters
    Map<Integer, Integer> map = new HashMap<>();
    // Initialize the HashMap with a single key-value pair (0, 1) to represent the empty substring
    map.put(0, 1);
    // Initialize a variable to keep track of the difference between the count of uppercase and
    // lowercase letters up to the current index
    int diff = 0;
    // Iterate over each character of the string S
    for (int i = 0; i < S.length(); i++) {
        char c = S.charAt(i);
        // Update the diff variable based on the current character
        diff += Character.isUpperCase(c) ? 1 : -1;
        // If the HashMap contains the diff key, then there must be a previous substring with
        // the same difference between the count of uppercase and lowercase letters
        if (map.containsKey(diff)) {
            // Increment the count variable by the value associated with the diff key in the HashMap
            count += map.get(diff);
        }
        // Increment the value associated with the diff key in the HashMap to indicate the occurrence
        // of a new substring with the same difference between the count of uppercase and lowercase letters
        map.put(diff, map.getOrDefault(diff, 0) + 1);
    }
    // Return the count variable, which represents the total number of substrings that have an equal
    // number of uppercase and lowercase letters
    return count;
}
} 
