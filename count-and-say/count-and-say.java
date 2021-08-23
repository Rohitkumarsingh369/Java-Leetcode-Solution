class Solution {
    public String countAndSay(int n) {
        
        if(n==1)
            return "1";
        
        if(n==2)
            return "11";
      
        String s="11";
        
        for(int i=3;i<=n;i++){
            int count=1;
            String temp="";
            s+='@';
            int len=s.length();
            char arr[]=s.toCharArray();
            
            for(int j=1;j<len;j++){
                
                if(arr[j]!=arr[j-1]){
                    temp+=count;
                    temp+=arr[j-1];
                    count=1;
                }
                else
                    count++;
            }
            s=temp;
        }
        return s;
    }
}