class Solution {

    private void solve (int idx, int[] nums,
                        List<Integer> al, Set<List<Integer>> ans) {
        
        if(idx == nums.length) {
            if(al.size() >= 2) {
                ans.add(new ArrayList<>(al));
            }
            return;
        }

        // pick 
        if(al.size() == 0 || al.get(al.size()-1) <= nums[idx]) {
            al.add(nums[idx]);
            solve(idx+1, nums, al, ans);
            al.remove(al.size() - 1);
        }

        // not pick
        solve(idx+1, nums, al, ans);
        

    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();

        List<Integer> al = new ArrayList<>();
        int idx = 0;
        solve(idx, nums, al, ans);

        return new ArrayList<>(ans);
        
    }
}