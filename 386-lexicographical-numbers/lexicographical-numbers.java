class Solution {

    private void solve(int i, int n, List<Integer> ans) {
        if(i > n) {
            return;
        }

        ans.add(i);

        for(int j=0;j<=9;j++) {
            if((i*10 + j) <= n) {
                solve(i*10+j,n, ans);
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=9;i++) {
            solve(i, n, ans);
        }
        return ans;
    }
}