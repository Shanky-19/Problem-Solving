class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        
        if(nums.length == 0) {
            return ans;
        }
        
        if(nums.length == 1) {
            ans.add(nums[0] + "");
            return ans;
        }

        int i = 0;
        int j = 1;
        while(j < nums.length) {
            if(nums[j] == nums[j-1] + 1) {
                j++;
            } else {
                int prev = nums[j-1];
                if(nums[i] == prev) {
                    ans.add(nums[i] + "");
                } else {
                    ans.add(nums[i] + "->" + prev);
                }

                i = j;
                j++;
            }
        }
        if(nums[j-1] == nums[i]) {
            ans.add(nums[i] + "");
        } else {
            ans.add(nums[i] + "->" + nums[j-1]);
        }

        return ans;

    }
}