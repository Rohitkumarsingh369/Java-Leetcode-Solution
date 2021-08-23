class Solution {
    public String reverseVowels(String str) {
        int i = 0;
    int j = str.length()-1;
    char[] str1 = str.toCharArray();
    while (i < j)
    {
        if (!isvowel(str1[i]))
        {
            i++;
            continue;
        }
        if (!isvowel(str1[j]))
        {
            j--;
            continue;
        }
  
        // swapping
        char t = str1[i];
        str1[i]= str1[j];
        str1[j]= t;
          
  
        i++;
        j--;
    }
    String str2 = String.copyValueOf(str1);
    return str2;
    }
    boolean isvowel(char c){
        if((c=='a')||(c=='e')||(c=='i')||(c=='o')||(c=='u') ||
          (c=='A')||(c=='E')||(c=='I')||(c=='O')||(c=='U'))
             return true;
        return false;
    }
}