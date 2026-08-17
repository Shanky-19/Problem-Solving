class Solution {
    int ans = Integer.MAX_VALUE;

    private void solve(int idx, int[] cookies, int[] child, int k) {
        if(idx == cookies.length) {
            int max = child[0];
            for(int val : child) {
                max = Math.max(max, val);
            }
            ans = Math.min(ans, max);
            return;
        }


        int cks = cookies[idx];
        for(int i=0;i<k;i++) {
            child[i] += cks;
            solve(idx+1, cookies, child, k);
            child[i] -= cks;
        }

    }

    public int distributeCookies(int[] cookies, int k) {
        int[] child = new int[k];
        int idx = 0;
        solve(idx, cookies, child, k);
        return ans;
    }
}