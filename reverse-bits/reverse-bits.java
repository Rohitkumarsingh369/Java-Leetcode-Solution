public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0, cnt = 32;
	while (cnt-- > 0) {
		ret = (ret << 1) | (n & 0x1);
		n = n >>> 1;
	}
	return ret;
    }
}