
// Brute Force
/*
class Solution {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        int idx = 0;
        Map<Integer, Integer> powerCastedSoFar = new HashMap<>();
        long ans = helper(n, power, idx, powerCastedSoFar);
        return ans;
    }

    private long helper(int n, int[] power, int idx, 
                    Map<Integer, Integer> powerCastedSoFar) {
        if(idx == n) {
            return 0L;
        }

        // pick
        int currPower = power[idx];
        long pick = 0L;
        if(canPickCurrPower(currPower, powerCastedSoFar)) {
            powerCastedSoFar.put(currPower, 
                        powerCastedSoFar.getOrDefault(currPower,0)+1);
            pick = power[idx] + helper(n, power, idx+1, powerCastedSoFar);
            powerCastedSoFar.put(currPower, powerCastedSoFar.get(currPower)-1);
            if(powerCastedSoFar.get(currPower) == 0) {
                powerCastedSoFar.remove(currPower);
            }
        }

        long notPick = helper(n, power, idx+1, powerCastedSoFar);

        return Math.max(pick, notPick);
    }

    private boolean canPickCurrPower(int currPower, 
                        Map<Integer, Integer> powerCastedSoFar) {
        if(powerCastedSoFar.containsKey(currPower-2)) {
            return false;
        }
        if(powerCastedSoFar.containsKey(currPower-1)) {
            return false;
        }
        if(powerCastedSoFar.containsKey(currPower+1)) {
            return false;
        }
        if(powerCastedSoFar.containsKey(currPower+2)) {
            return false;
        }
        return true;
    }
}
*/


//Approach-1 - Recursion + Memoization
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    private int n;
    private Map<Long, Long> freq;
    private long[] dp;

    private long solve(int i, List<Long> nums) {
        if (i >= n)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        // skip current damage
        long skip = solve(i + 1, nums);

        // take current damage
        int j = lowerBound(nums, i + 1, nums.get(i) + 3);
        long take = nums.get(i) * freq.get(nums.get(i)) + solve(j, nums);

        return dp[i] = Math.max(skip, take);
    }

    // Helper function to replicate C++ lower_bound
    private int lowerBound(List<Long> nums, int start, long target) {
        int low = start, high = nums.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public long maximumTotalDamage(int[] power) {
        freq = new HashMap<>();
        for (int x : power)
            freq.put((long)x, freq.getOrDefault((long)x, 0L) + 1);

        List<Long> nums = new ArrayList<>(freq.keySet());
        Collections.sort(nums);
        n = nums.size();
        dp = new long[n];
        Arrays.fill(dp, -1);

        return solve(0, nums);
    }
}
