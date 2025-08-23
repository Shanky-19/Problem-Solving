class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = bloomDay[0];
        for(int val: bloomDay) {
            max = Math.max(val, max);
        }
        int low = 1;
        int high = max;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;

            if(isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int adjacentBloomed = 0;
        int bouquets = 0;
        for(int i=0;i<bloomDay.length;i++) {
            int val = bloomDay[i];
            if(val <= day) {
                adjacentBloomed++;
                if(adjacentBloomed >= k) {
                    bouquets++;
                    adjacentBloomed = 0;
                }
            } else {
                if(adjacentBloomed >= k) {
                    bouquets++;
                }
                adjacentBloomed = 0;
            }
        }
        // System.out.println(day + " " + bouquets);
        if(bouquets < m){
            return false;
        }
        return true;
    }
}