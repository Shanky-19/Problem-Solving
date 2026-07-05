class Solution {
    public int minimumDistance(int[] nums) {
        // Brute Force
    
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++) {
            for(int j=i+1;j<n-1;j++) {
                if(nums[i] == nums[j]) {
                    for(int k=j+1;k<n;k++) {
                        if(nums[j] == nums[k]) {
                            int potentialAns = (Math.abs(i-j) + 
                                                Math.abs(j-k) + Math.abs(i-k));
                            ans = Math.min(ans, potentialAns); 
                        }
                    }
                }
            }
        }
        if(ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;

    }
}