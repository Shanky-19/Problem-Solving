class Solution {
    public long minEnd(int n, int x) {
        // first will always be x
        n--;

        long potentialNext = x+1;
        long ans = x;
        while(n > 0) {
            ans = (potentialNext | x);
            potentialNext = ans+1;
            n--;
        }
        return ans;
    }
}