class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
      list.add(1);

      long  num =1;
      for(int i = 1; i <= rowIndex; i++)
      {
         num = num * (rowIndex + 1 - i) / i;
         list.add((int) num);
      }


      return list;
    }
}