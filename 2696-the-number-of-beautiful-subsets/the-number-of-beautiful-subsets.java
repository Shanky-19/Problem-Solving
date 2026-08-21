class Solution {
    int ans = 0;
    private void solve(int idx, int[] nums, int k, Map<Integer, Integer> map) {
        if(idx == nums.length) {
            if(map.size() > 0) {
                ans++;
            }
            return;
        }

        
        if(!map.containsKey(nums[idx]-k) && !map.containsKey(k+nums[idx])) {
            // can pick
            map.put(nums[idx], map.getOrDefault(nums[idx],0)+1);
            solve(idx+1, nums, k, map);
            map.put(nums[idx], map.get(nums[idx])-1);
            if(map.get(nums[idx]) == 0) {
                map.remove(nums[idx]);
            }

        }

        solve(idx+1, nums, k, map);
    }

    public int beautifulSubsets(int[] nums, int k) {
        int idx = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        solve(idx, nums, k, hm);
        return ans;
    }
}