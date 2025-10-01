class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;
        while(empty >= numExchange) {
            int newFullBottles = empty/numExchange;
            int remEmptyBottles = empty%numExchange;

            ans += newFullBottles;
            empty = newFullBottles + remEmptyBottles;
        }
        return ans;
    }
}