class Solution {

    private long blackBox(long time, int[] batteries) {
        long totalTimeTaken = 0L;
        for(int battery : batteries) {
            if(time <= battery) {
                totalTimeTaken += time;
            } else {
                totalTimeTaken += battery;
            }
        }
        return totalTimeTaken;
    }
    public long maxRunTime(int n, int[] batteries) {
        long totalBatteryTime = 0L;
        for(int val : batteries) {
            totalBatteryTime += val;
        } 

        long low = 0L;
        long high = totalBatteryTime;
        long ans = 0L;
        while(low <= high) {
            long mid = low + (high - low)/2;
            
            long requiredTime = mid * n;
            long totalTimeTaken = blackBox(mid, batteries);

            if(requiredTime <= totalTimeTaken) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}