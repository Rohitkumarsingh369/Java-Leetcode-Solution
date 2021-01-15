class Solution {
    public List<List<Integer>> fourSum(int[] a, int sum) {
        List<List<Integer>> list=new ArrayList<>();
        if(a==null || a.length<4)
            return list;
        
        Arrays.sort(a);
        
        
        for(int i=0;i<=a.length-4;i++) {
            if (i-1 >= 0 && a[i] == a[i-1])
                continue;
            for(int j=i+1;j<=a.length-3;j++) {
                if (j>i+1 && a[j] == a[j-1]) {
                    continue;
                }
                int left=j+1;
                int right=a.length-1;
                int k=sum-(a[i]+a[j]);
                        
                while(left<right) {
                    if(a[left]+a[right]<k)
                        left++;
                    else if(a[left]+a[right]>k)
                        right--;
                    else 
                    {
                        list.add((Arrays.asList(a[i],a[j],a[left],a[right])));
                        while (left + 1 < right && a[left] == a[left+1])
                            left++;
                            while (left < right-1 && a[right] == a[right-1])
                                right--;
                        left++;
                        right--;
                    }
                }
            }
        }
     
         return list;
    }
}
