class Solution {
    public int calPoints(String[] ops) {
        int[] scores = new int[ops.length];
        int idx = 0;
        for (String op : ops) {
            if (op.equals("+")) {
                scores[idx] = scores[idx - 1] + scores[idx - 2];
                idx++;
            } else if (op.equals("D")) {
                scores[idx] = 2 * scores[idx - 1];
                idx++;
            } else if (op.equals("C")) {
                idx--;
                scores[idx] = 0;
            } else {
                scores[idx] = Integer.parseInt(op);
                idx++;
            }
        }
        
        int ans = 0;
        for (int score : scores) {
            ans += score;
        }
        return ans;
    }
}