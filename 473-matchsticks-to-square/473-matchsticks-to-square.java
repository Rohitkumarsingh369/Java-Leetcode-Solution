class Solution {
    public boolean makesquare(int[] nums) {
        Long sum=0l;
        for(int x:nums){
            sum=sum+x;
        }
        if(sum%4!=0||nums.length<4) return false;
        long width=(sum/4);
        Arrays.sort(nums);
        long sum1=0,sum2=0,sum3=0,sum4=0;
        return helper(nums,nums.length-1,sum1,sum2,sum3,sum4,width);
        
    }
    public boolean helper(int[] a, int i,long sum1,long sum2,long sum3,long sum4, long width){
        if(sum1>width||sum2>width||sum3>width||sum4>width) return false;
        if(i==-1){
            if(sum1==width&&sum2==width&&sum3==width&&sum4==width) return true;
            else return false;
        }
//check a[i]  belonging to side1,side2,side3,side4
        return helper(a,i-1,sum1+a[i],sum2,sum3,sum4,width)||
        helper(a,i-1,sum1,sum2+a[i],sum3,sum4,width)||
        helper(a,i-1,sum1,sum2,sum3+a[i],sum4,width)||
        helper(a,i-1,sum1,sum2,sum3,sum4+a[i],width);
    }
}