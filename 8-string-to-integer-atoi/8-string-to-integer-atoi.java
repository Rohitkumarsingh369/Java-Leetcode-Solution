class Solution {
    public int myAtoi(String s) {
        String ans = "0";
        char[]  arr = s.toCharArray();
        int ind = 0,sign = 0;
        
        //1) ignore the space
        while(ind<arr.length && arr[ind]==' ') ind++;
        
          //2) get positive or negative
        if(ind<arr.length && (arr[ind]=='+'||arr[ind]=='-')){
            sign = arr[ind++]=='+'?0:1;
        }
        
        for(;ind<arr.length;ind++){
            //3) non digit
            if(!Character.isDigit(arr[ind])) break;
            // add the integer
            ans+=arr[ind];
        }
        return check(ans,sign);
    }
    static int check(String s,int sign){
        try{
            return sign==1?-Integer.parseInt(s):Integer.parseInt(s);
        }catch(Exception e){
            return sign==1?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
    }
}