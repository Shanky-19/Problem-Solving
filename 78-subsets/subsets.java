class Solution {

    private void solve(int[] nums, int idx, 
                    List<List<Integer>> ans, int n,
                    List<Integer> curr) {
        if(idx == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // not pick
        solve(nums, idx+1, ans, n, curr);

        // pick 
        curr.add(nums[idx]);
        solve(nums, idx+1, ans, n, curr);
        curr.remove(curr.size()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        int idx = 0;
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(nums, idx, ans, n, curr);
        return ans;
    }
}