//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        // code here
        Stack<Character> st=new Stack<>();
        
        for(char c:s.toCharArray()){
            if(c!=']'){
                st.push(c);
            }
            else{
                StringBuilder sb=new StringBuilder();
                
                while(!st.isEmpty() && Character.isLetter(st.peek()))
                        sb.insert(0,st.pop());
                
                String letter=sb.toString();
                
                st.pop();
                
                sb.setLength(0);
                while(!st.isEmpty() && Character.isDigit(st.peek()))
                        sb.insert(0,st.pop());
                
                int count=Integer.valueOf(sb.toString());
                
                while(count>0){
                    for(char ch:letter.toCharArray())
                        st.push(ch);
                    count--;
                }
            }
        }
        
        StringBuilder result=new StringBuilder();
        while(!st.isEmpty()){
            result.insert(0,st.pop());
        }
        return result.toString();
    }
}