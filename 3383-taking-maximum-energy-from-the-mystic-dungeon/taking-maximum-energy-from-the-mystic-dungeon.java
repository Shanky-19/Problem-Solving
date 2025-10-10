class Solution {
    public int maximumEnergy(int[] energy, int k) {
        /*
        int n = energy.length;
        int[] eligibleAns = new int[n];
        Arrays.fill(eligibleAns, Integer.MIN_VALUE);

        for(int i=0;i<n;i++) {
            eligibleAns[i] = compute(i, k, energy);
        }
        int ans = Integer.MIN_VALUE;
        for (int val : eligibleAns) {
            ans = Math.max(ans, val);
        }
        return ans;
        */


        // smaller problem right to left
        int n = energy.length;
        int[] eligibleAns = new int[n];
        Arrays.fill(eligibleAns, Integer.MIN_VALUE);
        for (int i=n-1;i>=n-k;i--) {
            eligibleAns[i] = energy[i];
        }

        for(int i=n-k-1;i>=0;i--) {
            eligibleAns[i] = energy[i] + eligibleAns[i+k];
        }

        int ans = Integer.MIN_VALUE;
        for(int val : eligibleAns) {
            ans = Math.max(val, ans);
        }
        return ans;
    }

    private int compute (int i, int k, int[] energy) {
        int ans = 0;
        while (i < energy.length) {
            ans += energy[i];
            i += k;
        }
        return ans;
    }
}