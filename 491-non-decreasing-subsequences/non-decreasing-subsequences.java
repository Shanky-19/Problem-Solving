class Solution {

    private void solve (int idx, int prev, int[] nums,
            List<Integer> al, Set<List<Integer>> ans) {
        
        if(idx == nums.length) {
            if(al.size() >= 2) {
                ans.add(new ArrayList<>(al));
            }
            return;
        }

        if(prev == -101) {
            // pick 
            al.add(nums[idx]);
            solve(idx+1, nums[idx], nums, al, ans);
            al.remove(al.size() - 1);

            // not pick
            solve(idx+1, prev, nums, al, ans);
        } else {

            // pick 
            if(prev <= nums[idx]) {
                al.add(nums[idx]);
                solve(idx+1, nums[idx], nums, al, ans);
                al.remove(al.size() - 1);
            }

            // not pick
            solve(idx +1, prev, nums, al, ans);
        }

    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        int prev = -101; // as nums[i] <= 100 && nums[i] >= -100

        List<Integer> al = new ArrayList<>();
        int idx = 0;
        solve(idx, prev, nums, al, ans);

        return new ArrayList<>(ans);
        
    }
}