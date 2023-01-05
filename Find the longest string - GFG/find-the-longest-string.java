//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Trie{
    Trie children[]=new Trie[26];
    boolean isWord;
    Trie(){
        isWord=false;
        Arrays.fill(children,null);
    }
}
class Solution {
    static Trie root;
    public static void insert(Trie root,String key){
        Trie node=root;
        for(int i=0;i<key.length();i++){
            if(node.children[key.charAt(i)-'a']==null){
                node.children[key.charAt(i)-'a']=new Trie();
            }
            node=node.children[key.charAt(i)-'a'];
        }
        node.isWord=true;
    }
    public static boolean  isPrefix(Trie root,String key){
        Trie node=root;
        for(int i=0;i<key.length();i++){
            node=node.children[key.charAt(i)-'a'];
            if(node.isWord==false){
                return false;
            }
        }
        return true;
    }
    public static String lexographical(String str1,String str2)
    {
        for(int i=0;i<str1.length();i++){
            if((str1.charAt(i)-'a')==(str2.charAt(i)-'a')){
                continue;
            }
            else if((str1.charAt(i)-'a')<(str2.charAt(i)-'a')){
                return str1;
            }
            else{
                return str2;
            }
        }
        return str1;
    }
    public static String longestString(int n, String[] arr) {
        
        // code here
        root=new Trie();
        for(int i=0;i<n;i++){
            insert(root,arr[i]);
        }
        String ans="";
        for(int i=0;i<n;i++)
        {
            if(isPrefix(root,arr[i])){
                if(ans.length()==arr[i].length()){
                    ans=lexographical(ans,arr[i]);
                }
                else if(ans.length()<arr[i].length()){
                    ans=arr[i];
                }
            }
        }
        return ans;
    }
}