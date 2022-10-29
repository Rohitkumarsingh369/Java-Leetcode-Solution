//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Map<String,ArrayList<String>> map = new TreeMap<>();
        String cur = "";
        for(int i = 0; i < s.length(); i++) {
            List<String> current_list = new ArrayList<>();
            cur += s.charAt(i);
            for(String j: contact) {
                if(j.startsWith(cur)) {
                    if(!current_list.contains(j)) current_list.add(j);
                }
            }
            if(current_list.size() != 0) Collections.sort(current_list);
            else current_list.add("0");
            map.put(cur,new ArrayList<>(current_list));
        }
        for(Map.Entry<String,ArrayList<String>> p: map.entrySet()) {
            ans.add(new ArrayList<>(p.getValue()));
        }
        return ans;
    }
}