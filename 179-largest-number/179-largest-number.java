class Solution {
    public String largestNumber(int[] nums) {
        int index = 0;
        String[] arr = new String[nums.length];
        for(int val: nums) arr[index++] = val+"";
        
        Arrays.sort(arr, (a,b)->(b+a).compareTo(a+b));
        if(arr[0].equals("0")) return "0";
        
        /*for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }*/
        StringBuilder sb = new StringBuilder();
        for(String val: arr) sb.append(val);
        
        return sb.toString();
    }
}