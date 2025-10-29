class Solution {
    public int smallestNumber(int n) {
        int powOfTwo = 1;
        while (powOfTwo <= n) {
            powOfTwo *= 2;
        }
        if(powOfTwo == 1) {
            return 1;
        }
        return powOfTwo - 1;
    }
}