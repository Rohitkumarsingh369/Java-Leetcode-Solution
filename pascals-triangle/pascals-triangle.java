class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        if ( numRows >= 1 ) {
            List<Integer> list = new ArrayList<>(1);
            list.add(1);
            ans.add(list);
        }
        if ( numRows >= 2 ) {
            List<Integer> list = new ArrayList<>(2);
            list.add(1);
            list.add(1);
            ans.add(list);
        }
        for ( int i = 3; i <= numRows; i++ ) {
            List<Integer> list = new ArrayList<>(i);
            list.add(1);
            List<Integer> temp = ans.get(i-2);
            for ( int j = 1; j < i - 1; j++  ) {
                list.add( temp.get(j-1) + temp.get(j) );
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}