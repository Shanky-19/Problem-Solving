class Solution {
    private boolean check(int idx, int currentSum, String sq, int num) {
        if(idx == sq.length()) {
            return currentSum == num;
        }

        // small optimization
        if(currentSum > num) {
            return false;
        }


        int n = sq.length();
        boolean ans = false;
        for(int j=idx;j<n;j++) {
            String substr = sq.substring(idx, j+1);
            int val = Integer.parseInt(substr);

            ans = ans || check(j+1, currentSum+val, sq, num);
            if(ans) {
                return true;
            }
        }
        return false;
    }

    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i=1;i<=n;i++) {
            int sqVal = i*i;
            String sq = "" + (i*i);
            int idx = 0;
            int currentSum = 0;
            if(check(idx, currentSum, sq, i)) {
                ans += sqVal;
            }
        }
        return ans;
    }
}