class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0;
        for(int i=1;i<=nums.length;i++) {
            if(isPossible(i, nums)) {
                ans = i;
            }
        }
        return ans;
    }

    private boolean isPossible(int window, int[] nums) {
        int i=0;
        int j=0;
        Map<Integer, Integer> even = new HashMap<>();
        Map<Integer, Integer> odd  = new HashMap<>();
        while(j < nums.length) {
            
            while(j-i+1 > window) {
                if(nums[i]%2 == 0) {
                    even.put(nums[i], even.get(nums[i])-1);
                    if(even.get(nums[i]) == 0) {
                        even.remove(nums[i]);
                    }
                } else {
                    odd.put(nums[i], odd.get(nums[i])-1);
                    if(odd.get(nums[i]) == 0) {
                        odd.remove(nums[i]);
                    }
                }
                i++;
            }

            if(nums[j]%2 == 0) {
                even.put(nums[j], even.getOrDefault(nums[j], 0) + 1);
            } else {
                odd.put(nums[j], odd.getOrDefault(nums[j], 0) + 1);
            }

            if(j-i+1 == window && even.size() == odd.size()) {
                return true;
            }
            j++;
        }
        return false;
    }
}