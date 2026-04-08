class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int m = (int)(1e9 + 7);
        for(int[] query : queries) {
            int left = query[0];
            int right =query[1];
            int k = query[2];
            int val = query[3];

            for(int idx=left;idx<=right;idx+=k) {
                nums[idx] = (int) (((long)nums[idx] * val)%m);
            }
        }

        int xor = nums[0];
        for (int i=1;i<nums.length;i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}