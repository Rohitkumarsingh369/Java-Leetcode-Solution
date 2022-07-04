class Solution {
    public int candy(int[] kid) {
  int sum = kid.length;
  int inc = 0;
  int dec = 0;
  
  for (int i = 1; i < kid.length; ++i) {
    if (kid[i - 1] < kid[i]) {
	  sum += (++inc);
	}
	else if (kid[i - 1] == kid[i]) {
	  inc = 0;
	}
	else {
	  sum += (dec++);
      // compensation settlement
	  if (i + 1 == kid.length || kid[i] <= kid[i + 1])
	    sum += Math.max(dec - inc, dec = inc = 0);
	}
  }
  return sum;
}
}