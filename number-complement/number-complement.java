class Solution {
    public int findComplement(int num) {
        int sum=0;
        List<Integer> n = new ArrayList<Integer>();
        //Convert Decimal to Binary
        while(num!=0)
        {
            n.add(num%2);
            num = num/2;
            if(num==1)
            {
                n.add(num);
                num=0;
            }       
        }
        //Complement it
        for(int i=0;i<n.size();i++)
        {
            if(n.get(i)==1)
            {
                n.set(i,0);
            }else
            {
                n.set(i,1);
            }
        }
        //Convert back to decimal
        int count=1;
        for(int i=0;i<n.size();i++)
        {
             sum += n.get(i)*count;
             count *= 2;
        }
        return sum;
    }
}