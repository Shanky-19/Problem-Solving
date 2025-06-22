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
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int num : nums)
            right.put(num, right.getOrDefault(num, 0) + 1);

        long res = 0;
        for (int num : nums) {
            right.put(num, right.get(num) - 1);
            res += 1L * left.getOrDefault(num * 2, 0) * right.getOrDefault(num * 2, 0);
            res %= MOD;
            left.put(num, left.getOrDefault(num, 0) + 1);
        }

        return (int) res;

    }
}