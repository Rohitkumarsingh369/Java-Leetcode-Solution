class Solution {
    public boolean winnerOfGame(String c) {
        int n=c.length(), p[]=new int[2];
        for(int i=0, j; i<n;) {
            for(j=i; j<n && c.charAt(i)==c.charAt(j); j++);
            p[c.charAt(i)-'A'] += Math.max(0, (j-i)-2);
            i=j;
        }
        return p[0] > p[1];
    }
}