class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // brute force
        int m = worker.length;
        int n = profit.length;
        int ans = 0;
        for(int i=0;i<m;i++) {
            int ability = worker[i];
            int maxProfit = 0;
            for(int j=0;j<n;j++) {
                if(ability >= difficulty[j]) {
                    maxProfit = Math.max(maxProfit, profit[j]);
                }
            }
            ans += maxProfit;
        }
        return ans;
    }
}