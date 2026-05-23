class Solution {
    int mod = 1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            long sum = nums[i];
            list.add(sum);
            for(int j=i+1;j<n;j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);

        int ans = 0;
        for(int i=left-1;i<=right-1;i++) {
            ans += list.get(i);
            ans %= mod;
        }
        return ans%mod;
    }
}