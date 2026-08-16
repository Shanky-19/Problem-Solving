class Solution {

    private void solve (int idx, int[] nums,
                        List<Integer> al, List<List<Integer>> ans) {
        
        if(al.size() >= 2) {
            ans.add(new ArrayList<>(al));
        }

        Set<Integer> set = new HashSet<>();

        for(int i = idx;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                continue;
            }

            if (al.size() == 0 || nums[i] >= al.get(al.size() - 1)) { 
                set.add(nums[i]);

                al.add(nums[i]);
                solve(i+1, nums, al, ans);
                al.remove(al.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        int idx = 0;
        solve(idx, nums, al, ans);

        return ans;
        
    }
}