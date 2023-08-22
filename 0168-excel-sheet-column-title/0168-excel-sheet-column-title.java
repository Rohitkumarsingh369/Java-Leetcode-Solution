class Solution {
    public String convertToTitle(int columnnumber) {
        StringBuilder columnname=new StringBuilder();
        
        while(columnnumber>0){
            int remainder=columnnumber%26;
            
            if(remainder==0){
                columnname.append('Z');
                columnnumber=(columnnumber/26)-1;
            }
            else{
                columnname.append((char)((remainder-1)+'A'));
                columnnumber/=26;
            }
        }
        
        return columnname.reverse().toString();
    }
}