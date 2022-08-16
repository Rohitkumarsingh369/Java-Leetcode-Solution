class ProductOfNumbers {

    ArrayList<Integer> list;
    public ProductOfNumbers() {
        list=new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(0,num);
    }
    
    public int getProduct(int k) {
        int result=1;
        int pos=0;
        while(k-->0){
            result*=list.get(pos++);
        }
        return result;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */