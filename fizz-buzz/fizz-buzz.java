class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list=new ArrayList<>();
        
        String result="";
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0)
                result="FizzBuzz";
            else if(i%3==0)
                result="Fizz";
            else if(i%5==0)
                result="Buzz";
            else if(i%3!=0 && i%5!=0)
                result=String.valueOf(i);
            
            list.add(result);
            result="";
        }
        return list;
    }
}