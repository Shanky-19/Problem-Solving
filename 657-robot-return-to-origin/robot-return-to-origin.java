class Solution {
    public boolean judgeCircle(String moves) {
        int currX = 0;
        int currY = 0;
        for (char ch : moves.toCharArray()) {
            if(ch == 'U') {
                currY++;
            } else if(ch == 'D') {
                currY--;
            } else if(ch == 'R') {
                currX++;
            } else {
                currX--;
            }
        } 
        return (currX == 0 && currY == 0);
        
    }
}