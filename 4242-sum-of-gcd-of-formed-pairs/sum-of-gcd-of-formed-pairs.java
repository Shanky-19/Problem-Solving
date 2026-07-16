class Solution {

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        
        int[] prefixGcd = new int[n];
        prefixGcd[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<n;i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(max, nums[i]); // a > b
        }

        Arrays.sort(prefixGcd);

        long ans = 0;

        int i = 0;
        int j = n-1;
        while(i < j) {
            int mini = prefixGcd[i];
            int maxi = prefixGcd[j];

            ans += gcd(maxi, mini);
            i++;
            j--;
        }
        return ans;
    }
}