class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int val : banned) {
            set.add(val);
            // currSum += val;
        }

        int currSum = 0;
        int ans = 0;
        for(int i=1;i<=n;i++) {
            if(!set.contains(i) && currSum + i <= maxSum) {
                set.add(i);
                ans++;
                currSum += i;
            }
        }
        return ans;
    }
}