class Solution {
    public boolean canAliceWin(int n) {
        int toBeRemoved = 10;
        boolean alice = true;
        while(true) {
            if(alice) {
                if(n >= toBeRemoved) {
                    n -= toBeRemoved;
                    toBeRemoved--;
                } else {
                    return false;
                }
                
                alice = false;
            } else {
                if(n >= toBeRemoved) {
                    n -= toBeRemoved;
                    toBeRemoved--;
                } else {
                    return true;
                }
                alice = true;
            }
        }
    }
}