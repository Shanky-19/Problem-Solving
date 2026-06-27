class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        // [2..9] = 8 numbers
        int currPush = 1;
        int pushes = 0;
        while (n > 8) {
            pushes += (currPush * 8);
            currPush++;
            n -= 8;
        }
        
        pushes += (currPush * n);
        return pushes;
    }
}