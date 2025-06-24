class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=i-k;j<=i+k;j++) {
                if(j<n && j>=0 && nums[j] == key) {
                    ans.add(i);
                    break;
                }
            }
            
        }
        return ans;
    }
}