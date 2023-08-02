class Solution {
    List<List<Integer>> ls=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,0,nums.length-1);
        return ls;
    }
    public void helper(int[] a,int start,int end){
        if(start==end){
            List<Integer> out=new ArrayList<>();
           for(int i:a)
               out.add(i);
            ls.add(out);
        }
        else{
            for(int i=start;i<=end;i++){
                int t1=a[i];
                a[i]=a[start];
                a[start]=t1;
                helper(a,start+1,end);
                int t2=a[i];
                a[i]=a[start];
                a[start]=t2;
            }
        }
            
    }
}