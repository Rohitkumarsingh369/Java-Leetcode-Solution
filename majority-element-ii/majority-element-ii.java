class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //initialize
        int num1 = -1,num2 = -1,count1 = 0,count2 = 0,n = nums.length;
        
        //step 1 : find candidates
        for(int element : nums){
            if(element == num1){
                count1++;
            }else if(element == num2){
                count2++;
            }else if(count1 == 0){
                num1 = element;
                count1 = 1;
            }else if(count2 == 0){
                num2 = element;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        
        //step 2 : verify candidates
        count1 = 0;count2 = 0;
        List<Integer> res = new ArrayList<>();
        for(int i : nums){
            if(i == num1)count1++;
            if(i == num2)count2++;
        }
        
        //step 3 : add to result and return 
        if(count1 > n/3)res.add(num1);
        if(count2 > n/3 && num1 != num2)res.add(num2);
        return res;
    }
}