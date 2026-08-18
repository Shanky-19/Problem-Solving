class Solution {
    int ans = 0;
    private void solve(int idx, int[][] requests, int n, 
                        int[] buildings, int count) {
        if(idx == requests.length) {
            for(int val : buildings) {
                if(val != 0) {
                    count = 0;
                }
            }

            ans = Math.max(ans, count);
            return;
        }

        // pick
        int from = requests[idx][0];
        int to   = requests[idx][1];
        buildings[from]--;
        buildings[to]++;
        solve(idx+1, requests, n, buildings, count+1);
        buildings[from]++;
        buildings[to]--;

        // not pick
        solve(idx +1, requests, n, buildings, count);
    }

    public int maximumRequests(int n, int[][] requests) {
        int idx = 0;
        int count = 0;
        int[] buildings = new int[n];
        solve(idx, requests, n, buildings, count);
        return ans;
    }
}