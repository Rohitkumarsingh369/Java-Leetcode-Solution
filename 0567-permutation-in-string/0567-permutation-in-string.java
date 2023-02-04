class Solution { 
	// Function to ensure count of all letters is 0.
    private boolean checkMap(int[] arr){
        for (int i: arr) if (i != 0) return false;
        return true;
    }
    
	// Main function
    public boolean checkInclusion(String s1, String s2) {
		// Array to store frequencies
        int[] map = new int[26]; 
        
		// Add frequencies of string we're looking for
        for (char toAdd: s1.toCharArray()) map[toAdd - 'a']++; 
        
		// Main loop of function
        for (int i = 0, j = 0, s1Len = s1.length() - 1; j < s2.length(); j++){
			// Subtract from array
            map[s2.charAt(j) - 'a']--; 
			// This code removes the leftmost element by adding it
            if (j-i > s1Len) map[s2.charAt(i++) - 'a']++;
			// Checks if frequency of all characters is zero (meaning a match)
            if (checkMap(map)) return true;            
        }
        
		// Returns false if no matches found
        return false;
    }
}