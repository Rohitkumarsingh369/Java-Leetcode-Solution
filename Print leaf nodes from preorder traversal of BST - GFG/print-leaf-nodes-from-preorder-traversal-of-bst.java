//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    ArrayList<Integer> ans;
    public int[] leafNodes(int arr[], int N)
    {
        ans=new ArrayList<>();
        Node root=new Node();
       for(int i=0;i<arr.length;i++){
           root=build(root,arr[i]);
       }
       traverse(root);
       int[] res=new int[ans.size()];
       for(int i=0;i<ans.size();i++){
           res[i]=ans.get(i);
       }
       return res;
    }
    private void traverse(Node root){
        if(root==null) return;
        
        traverse(root.left);
        if(root.left==null && root.right==null){
            ans.add(root.data);
        }
        traverse(root.right);
    }
    private Node build(Node root,int element){
        if(root==null){
            root=new Node(element);
        }
        if(root.data<element){
            root.right=build(root.right,element);
        }
        if(root.data>element){
            root.left=build(root.left,element);
        }
        return root;
    }
    class Node{
        int data;
        Node left,right;
        Node(){}
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
}