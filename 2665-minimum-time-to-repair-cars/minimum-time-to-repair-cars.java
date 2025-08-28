class Solution {
    public long repairCars(int[] ranks, int cars) {
        int m = ranks.length;
        long low = 0;
        int max = 0;
        for(int i=0;i<m;i++) {
            max = Math.max(ranks[i], max);
        }
        long high = (cars * 1L) * max * cars;
        long ans = 0;
        while(low <= high) {
            long mid = low + (high - low)/2;
            if(isPossible(mid, ranks, cars)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible (long time, int[] ranks, int cars) {
        long totalCarsRepaired = 0;
        
        for(int rank : ranks) {
            // cars this mechanic can 
            // repair in time 
            long c = (long)Math.sqrt(time/rank);
            totalCarsRepaired += c;
        }
        return (totalCarsRepaired >= cars);
    }
}