class Solution {
    public int bestClosingTime(String customers) {

        int n = customers.length();
        int[] prefix_n = new int[n + 1];
        int[] postfix_y = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            prefix_n[i] = prefix_n[i - 1];
            if (customers.charAt(i - 1) == 'N')
                prefix_n[i] += 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            postfix_y[i] = postfix_y[i + 1];
            if (customers.charAt(i) == 'Y')
                postfix_y[i] += 1;
        }

        int min_penalty = Integer.MAX_VALUE, idx = -1, penalty = 0;

        for (int i = 0; i < n + 1; i++) {
            penalty = prefix_n[i] + postfix_y[i];
            if (penalty < min_penalty) {
                min_penalty = penalty;
                idx = i;
            }
        }

        return idx;
    }
}