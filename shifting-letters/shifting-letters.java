class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] arr = s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int shift=0;
        for(int i=arr.length-1;i>=0;i--){
            shift=(shift+shifts[i])%26;
            arr[i]=(char)(((arr[i]-'a'+shift)%26)+'a');
        }
        return new String(arr);
    }
}