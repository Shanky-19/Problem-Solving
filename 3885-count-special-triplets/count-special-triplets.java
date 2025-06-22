class Solution {
    int max = 1000000007;
    public int specialTriplets(int[] nums) {
        // Brute Force
        /*
        int ans = 0;
        int n = nums.length;
        for(int j=1;j<n-1;j++) {
            int count1 = 0;
            int count2 = 0;
            for(int i=0;i<j;i++) {
                if(nums[i] == nums[j] * 2) {
                    count1++;
                }
            }

            for(int k=j+1;k<n;k++) {
                if(nums[k] == nums[j] * 2) {
                    count2++;
                }
            }

            ans += ((count1 * count2)%max);
        }
        return ans;
        */

        // optimized
        final int max = 1000000007;
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int num : nums) {
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
        }
        long ans = 0;
        for (int num : nums) {
            rightMap.put(num, rightMap.get(num) - 1);
            ans += 1L * 
            leftMap.getOrDefault(num * 2, 0) 
            * rightMap.getOrDefault(num * 2, 0);
            ans %= max;
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
        }
        return (int) ans;
    }
}