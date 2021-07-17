class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
       /* int sum=0;
        for(int num:arr){
            sum+=num;
        }//The foreach statement is used here to sum up. You can see the supplementary content of my array
        
        if(sum%3!=0)
            return false;
        int key=sum/3;
        int group=0;
        for(int i=0;i<arr.length;i++){
            key-=arr[i];
            if(key==0){
                group++;
                key=sum/3;
            }
        }
        return group==3;*/
        int sum = 0, tempSum = 0, count = 0;
        for (int i: arr) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            if (tempSum == sum / 3) {
                tempSum = 0;
                count++;
                if (count == 3) {
                    break;
                }
            }
        }

        return count == 3;
    }
}