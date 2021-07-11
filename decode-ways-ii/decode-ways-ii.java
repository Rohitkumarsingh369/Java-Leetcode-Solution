class Solution {
    public int numDecodings(String s) {
        int mod = 1000000007;
        
        long last = 1, secondLast = 1;
        
        // if the digits start with 0, no decoding is possible
        if (s.charAt(0) == '0') {
            return 0;
        }
        
        // if the digit start with *, we can nine decodings, otherwise only one
        last = s.charAt(0) == '*' ? 9 : 1;
        
        // iterating for all remaining digits
        for (int i = 1; i < s.length(); i++) {
            
            char prev = s.charAt(i - 1);
            char cur = s.charAt(i);
            
            // finding number of decodings by combining the previous digit
            long incPrev = 0;
            if (prev == '*') {
                if (cur == '*') {
                    // For '**', fifteen decodings are possible: 11, 12, 13 ... 19, 21, 22, ..., 26
                    incPrev = 15;
                } else {
                    if (cur > '6') {
                        // For '*7' or more, only one decoding is possible: 17 or 18 or 19
                        incPrev = 1;
                    } else {
                        // Else, we can have these decodings as: 11, 12 ... or 21, 22 ... (two kinds)
                        incPrev = 2;
                    }
                }
            } else if (prev == '1') {
                if (cur == '*') {
                    // for '1*', we can nine decodings
                    incPrev = 9;
                } else {
                    // for *(any_digit) with anything else, we can have only 1 decoding
                    incPrev = 1;
                }
            } else if (prev == '2') {
                if (cur == '*') {
                    // for '2*', we can only 6 decodings: 21, 22, 23, 24, 25, 26
                    incPrev = 6;
                } else if (cur <= '6') {
                    // else only one decoding is possible
                    incPrev = 1;
                }
            }
            
            // without combining with previous digit
            long incCur = 0;
            if (cur == '*') {
                // For '*', nine decodings are possible
                incCur = 9;
            } else if (cur > '0') {
                incCur = 1;
            }
            
            // Calculating separate counts by including an excluding previous digit
            long incPrevTotal = (incPrev * secondLast) % mod;
            long incCurTotal = (incCur * last) % mod;
            
            // assing secondLast to last for next interation
            secondLast = last;
            // Total number of decodings until this digit
            last = (incPrevTotal + incCurTotal) % mod;
            
            
        }
        
        return (int) last;
        
        
    }
}