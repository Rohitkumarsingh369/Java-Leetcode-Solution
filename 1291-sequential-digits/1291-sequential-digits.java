class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> ans=new ArrayList();
        
        String digit="123456789";
        
        int low_count=String.valueOf(low).length();
        int high_count=String.valueOf(high).length();
        
        for(int i=low_count;i<=high_count;i++){
            for(int j=0;j<10-i;j++){
                int num=Integer.parseInt(digit.substring(j,j+i));
                
                if(num>=low && num<=high){
                    ans.add(num);
                }
            }
        }
        
        return ans;
    }
}