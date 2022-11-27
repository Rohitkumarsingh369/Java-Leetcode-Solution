//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
		// code here
		String temp;
		if (A.length() < B.length()) {
			temp = A;
			A = B;
			B = temp;
		}
		int n = B.length();
		char sum_carry[] = new char[2];
		sum_carry[0] = sum_carry[1] = '0';
		StringBuffer sb = new StringBuffer();
		int j=A.length()-1;
		for (int i = n - 1; i > -1; i--) {
			char carry = sum_carry[1];
			sum_carry = add(A.charAt(j--), B.charAt(i), carry);
			sb.append(sum_carry[0]);
		}
		for (int i = A.length() - n - 1; i > -1; i--) {
			char carry = sum_carry[1];
			sum_carry = add(A.charAt(i), '0', carry);
			sb.append(sum_carry[0]);
		}
		if (sum_carry[1] == '1')
			sb.append('1');
		int k=0;
		sb=sb.reverse();
		while(sb.charAt(k)=='0') {
			k++;
		}
		return sb.substring(k);
	}

	private char[] add(char a, char b, char carry) {
		char[] ans = new char[2];
		ans[0] = ans[1] = '0';
		int x = Integer.parseInt(Character.toString(a), 2);
		int y = Integer.parseInt(Character.toString(b), 2);
		int z = Integer.parseInt(Character.toString(carry), 2);
		int xc, yc, zc;
		if (x == 1)xc = 0;else xc = 1;
		if (y == 1)yc = 0;else yc = 1;
		if (z == 1)zc = 0;else zc = 1;
		int sum = (xc & yc & z) | (xc & y & zc) | (x & yc & zc) | (x & y & z);
		int carr = (xc & y & z) | (x & y & zc) | (x & yc & z) | (x & y & z);
		if (sum == 1) ans[0] = '1';
		if (carr == 1) ans[1] = '1';
		return ans;

	}
}