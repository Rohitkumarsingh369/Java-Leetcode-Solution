class Solution {
    public int maximumScore(int[] nums, int k) {
         // **** initialization ****
        int len = nums.length;

        // **** generate and populate the scores array ****
        int[] scores    = new int[len];
        scores[k]       = nums[k];

        // **** go left - O(n) ****
        for (int i = k - 1; i >= 0; i--)
            scores[i] = nums[i] < scores[i + 1] ? nums[i] : scores[i + 1];

        // **** go right - O(n) ****
        for (int i = k + 1; i < len; i++)
            scores[i] = nums[i] < scores[i - 1] ? nums[i] : scores[i - 1];

        // **** loop looking for the maximum score (greedy) - O(n) ****
        int maxScore    = -1;
        int left        = k;
        int right       = k;
        while (true) {

            // **** compute current score ****
            int currentScore = (scores[left] < scores[right]) ? scores[left] : scores[right];

            // **** determine if we found a better score ****
            maxScore = (maxScore > (right - left + 1) * currentScore) ? maxScore : (right - left + 1) * currentScore;

            // ???? ????
            //System.out.println("<<< maxScore: " + maxScore + " (" + left + "," + right + ")");

            // **** check if done with the loop ****
            if (left == 0 && right == len - 1)
                break;

            // **** determine direction to grow subarray ****
            if (left == 0)
                right++;                        // must go right
            else if (right == len - 1)
                left--;                         // must go left
            else if (scores[left - 1] > scores[right + 1])
                left--;                         // go left
            else 
                right++;                        // go right
        }

        // **** return max score ****
        return maxScore;
    }
}