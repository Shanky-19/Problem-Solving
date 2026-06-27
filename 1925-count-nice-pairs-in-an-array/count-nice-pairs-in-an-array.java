class Solution {
    int mod = (int)((1e9) + 7);

    public int reverse(int val) {
        int ans = 0;
        while(val > 0) {
            int rem = val%10;
            ans = ans * 10 + rem;
            val = val/10;
        }
        return ans;
    }

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for(int val : nums) {
            int x = val - reverse(val);
            // System.out.println(val + " " + reverse(val));
            ans = (ans + hm.getOrDefault(x,0))%mod;
            hm.put(x, hm.getOrDefault(x,0)+1);
        }
        return ans%mod;
    }
}


// -18 -> 3
// 9 -> 2
