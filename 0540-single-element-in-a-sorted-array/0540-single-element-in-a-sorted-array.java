class Solution {
    public int singleNonDuplicate(int[] num) {
        
        /*int result=0;
        for(int i=0;i<nums.length;i++){
            result=result^nums[i];
        }
        return result;*/
        
        int len=num.length;
        
        if(len==1)
            return num[0];
        
        if(num[0]!=num[1])
            return num[0];
        
        if(num[len-1]!=num[len-2])
            return num[len-1];
        
        int low=1,high=len-2;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(num[mid]!=num[mid+1] && num[mid]!=num[mid-1])
                return num[mid];
            
            if((mid%2==1 && num[mid]==num[mid-1])||(mid%2==0 && num[mid]==num[mid+1]))
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;   
    }
}