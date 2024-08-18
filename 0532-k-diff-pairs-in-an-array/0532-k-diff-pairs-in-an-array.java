class Solution {
    // public int findPairs(int[] nums, int k) {
    //      Arrays.sort(nums);
    //     int count=0;
    //     for(int i=0;i<nums.length;i++)
    //     {  
    //         int low=i+1;
    //         int high=nums.length-1;
    //         while(low<=high)
    //         {
    //             int mid=low+(high-low)/2;
    //             if(nums[mid]-nums[i]==k)
    //             {count++;
    //              break;
    //             }else if(nums[mid]-nums[i]>k)
    //                 high=mid-1;
    //             else
    //                 low=mid+1;
    //         }
    //         while(i!=nums.length-1 && nums[i+1]==nums[i])
    //             i++;
    //     }
    //     return count;
    // }
    public int findPairs(int[] nums, int k) {
       if (k < 0) {
            return 0;  // Since absolute difference can't be negative
        }
        
        Set<Integer> numsSet = new HashSet<>();
        Set<Integer> visitedPairs = new HashSet<>();
        
        for (int num : nums) {
            if (numsSet.contains(num + k)) {
                visitedPairs.add(num);
            }
            if (numsSet.contains(num - k)) {
                visitedPairs.add(num - k);
            }
            numsSet.add(num);
        }
        
        return visitedPairs.size();
    }
}