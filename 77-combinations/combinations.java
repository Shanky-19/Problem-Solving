class Solution {

    private void solve (int num, int n,int k, List<Integer> list, 
                        List<List<Integer>> ans){
        if(list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=num;i<=n;i++) {
            list.add(i);

            solve(i+1, n, k, list, ans);
            list.remove(list.size()-1);

        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        int num = 1;
        solve(num, n, k, list, ans);
        
        return ans;
    }
}