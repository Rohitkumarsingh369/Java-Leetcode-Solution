/*class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        int left[]=new int[n];
        int right[]=new int[n];
        int product[]=new int[n];
        
        left[0]=1;
        right[n-1]=1;
        
        for(int i=1;i<n;i++){
            left[i]=arr[i-1]*left[i-1];
        }
        
        for(int i=n-2;i>=0;i--){
            right[i]=arr[i+1]*right[i+1];
        }
        
        for(int i=0;i<n;i++){
            product[i]=left[i]*right[i];
        }
        
        return product;
    }
}*/
class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] product = new int[n];
        
        // Calculate left products
        int left = 1;
        for (int i = 0; i < n; i++) {
            product[i] = left;
            left *= arr[i];
        }
        
        // Calculate right products and simultaneously multiply with left products
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            product[i] *= right;
            right *= arr[i];
        }
        
        return product;
    }
}
