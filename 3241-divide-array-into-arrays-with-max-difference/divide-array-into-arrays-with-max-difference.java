class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int x = 0;
        while(x+2 < n) {
            int diff = nums[x+2] - nums[x];
            // System.out.println(nums[x+2] + " " + nums[x]);
            if(diff > k) {
                return new int[0][0];
            }
            x += 3;
        }
        // int size = n/3;
        int[][] ans = new int[n/3][3];
        for(int i=0;i<n;i+=3) {
            int[] arr = new int[3];
            for(int j=0;j<3;j++) {
                arr[j] = nums[i+j];
            }
            ans[i/3] = arr;
        }
        return ans;
    }
}