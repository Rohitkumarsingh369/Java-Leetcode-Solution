class Solution {
   public String largestGoodInteger(String num) {
    String maxSubstring = "000";
    char[] currSubstring = new char[3];
    boolean emptySubstring = true;
    int currIndex = 0;
    for (int i = 0; i < num.length() - 2; i++) {
        currSubstring[0] = num.charAt(i);
        if (num.charAt(i + 1) == currSubstring[0] && num.charAt(i + 2) == currSubstring[0]) {
            currIndex = i + 3;
            currSubstring[1] = num.charAt(i + 1);
            currSubstring[2] = num.charAt(i + 2);
            emptySubstring = false;
            int newSubstring = Integer.parseInt(new String(currSubstring));
            if (newSubstring > Integer.parseInt(maxSubstring)) {
                maxSubstring = Integer.toString(newSubstring);
                
            }
        }
    }
    
    if (emptySubstring) {
        maxSubstring = "";
    }

    return maxSubstring;
}
}