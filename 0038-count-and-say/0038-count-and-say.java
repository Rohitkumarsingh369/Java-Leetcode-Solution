class Solution {
    public String countAndSay(int n) {
        
        String str="1";
        
        for(int i=2;i<=n;i++){
            str=countAndAdd(str);
        }
        
        return str;
    }
    public String countAndAdd(String str){
        StringBuilder temp=new StringBuilder();
        
        char ch=str.charAt(0);
        int count=1;
        
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==ch){
                count++;
            }
            else{
                temp.append(count);
                temp.append(ch);
                ch=str.charAt(i);
                count=1;
            }
        }
         temp.append(count);
         temp.append(ch);
        
        return temp.toString();
    }
}