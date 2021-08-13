class Solution {
    static final int max=256;

    static boolean compare(char arr1[],char arr2[]){
        
        for(int i=0;i<max;i++){
            if(arr1[i]!=arr2[i])
                return false;
        }
        
        return true;
    }
    
    public List<Integer> findAnagrams(String txt, String pat) {
        
        List<Integer> list=new ArrayList<>();
        int M=pat.length();
        int N=txt.length();
        
        
        if(M>N)
            return list;
        char countp[]=new char[max];
        char counttw[]=new char[max];
        
        int count=0;
        
        for(int i=0;i<M;i++){
            (countp[pat.charAt(i)])++;
            (counttw[txt.charAt(i)])++;
        }
        
        for(int i=M;i<N;i++){
            if(compare(countp,counttw))
                list.add(i-M);
                
            (counttw[txt.charAt(i)])++;
            
            (counttw[txt.charAt(i-M)])--;
        }
        if(compare(countp,counttw))
                list.add(N-M);
                
                
        return list;
    }
}