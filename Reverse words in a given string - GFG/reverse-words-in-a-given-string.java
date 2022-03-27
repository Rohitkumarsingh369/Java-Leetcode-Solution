// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
         S=S.trim();
       S=S+'.';
        int len=S.length();
        //System.out.println(len);
        String word="",result="";
        for(int i=0;i<len;i++){
            if(S.charAt(i)!='.')
                word+=S.charAt(i);
            else
            {
                result=word+'.'+result;
                word="";
            }
        }
        StringBuffer sb=new StringBuffer(result);
        sb.delete(sb.length()-1,sb.length());
        
        return sb.toString();
    }
}