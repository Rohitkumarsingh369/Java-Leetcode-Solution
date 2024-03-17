class Solution {
   /* public int maxProduct(int[] arr) {
        // Variables to store maximum and minimum
        // product till ith index.
        int minVal = arr[0];
        int maxVal = arr[0];
      
        int maxProduct = arr[0];
        int n=arr.length;
        for (int i = 1; i < n; i++)
        {
      
            // When multiplied by -ve number,
            // maxVal becomes minVal
            // and minVal becomes maxVal.
            if (arr[i] < 0)
            {
                int temp = maxVal;
                maxVal = minVal;
                minVal =temp;
              
            }
      
            // maxVal and minVal stores the
            // product of subarray ending at arr[i].
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);
      
            // Max Product of array.
            maxProduct = Math.max(maxProduct, maxVal);
        }
      
        // Return maximum product found in array.
        return maxProduct;
    }*/
     public int maxProduct(int[] arr) {
        
       /* if(nums.length==1)
            return nums[0];
        int ch1=1,ch2=1,ma=nums[0],mi=nums[0],pro=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            
                
                ch1=nums[i]*mi;
                ch2=nums[i]*ma;
                mi=Math.min(nums[i],Math.min(ch1,ch2));
                ma=Math.max(nums[i],Math.max(ch1,ch2));
                pro=Math.max(pro,Math.max(ma,mi));
        }
        return pro;*/
         
        int max=Integer.MIN_VALUE;
         int prefix=1,sufix=1;
         for(int i=0;i<arr.length;i++){
             
             if(prefix==0){
                 prefix=1;
             }
             
             if(sufix==0){
                 sufix=1;
             }
             prefix*=arr[i];
             sufix*=arr[arr.length-1-i];
             max=Math.max(max,Math.max(prefix,sufix));
         }
         return max;
    }
         
}