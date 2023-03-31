/*class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y++;
            else if (move == 'D') y--;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}*/
class Solution {
    public boolean judgeCircle(String moves) {
               
        int leftright = 0, updown = 0;
        for(int i = 0 ; i<moves.length() ; i++){
            if(moves.charAt(i) == 'U')  updown++;
            else if(moves.charAt(i) == 'D')  updown--;
            else if(moves.charAt(i) == 'R')  leftright++;
            else if(moves.charAt(i) == 'L')  leftright--;
        }
        return (updown == 0 && leftright == 0);
    }
}