class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 0;
        long high = (long) Math.pow(10,14);
        while(low < high) {
            long mid = low + (high - low)/2;
            long numberOfTripInMidTime = find(time, mid, totalTrips);
            if(numberOfTripInMidTime >= totalTrips) {
                // we can reduce time -> however this is potential answer
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return low;
    }

    private long find(int[] time, long t, int totalTrips) {
        long trips = 0;
        for(int val : time) {
            trips += t/val;
            // Optimization
            if(trips >= totalTrips){
                return trips;
            }
        }
        return trips;
    }
}