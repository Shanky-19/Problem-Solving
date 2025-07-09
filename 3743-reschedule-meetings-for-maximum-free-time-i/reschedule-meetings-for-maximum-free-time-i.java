class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> freeTimes = new ArrayList<>();
        if(startTime[0]-0 > 0) {
            freeTimes.add(startTime[0]-0);
        }
        int n = startTime.length;
        for(int i=1;i<n;i++) {
            int currentStartTime = startTime[i];
            int prevEndTime = endTime[i-1];

            freeTimes.add(currentStartTime - prevEndTime);
        }
        if(eventTime-endTime[n-1] > 0) {
            freeTimes.add(eventTime - endTime[n-1]);
        }
        
        // System.out.println(freeTimes);
        // window size = k+1
        int i = 0;
        int j = 0;
        int ans = 0;
        int sum = 0;
        while(j < freeTimes.size()) {
            int windowSize = j-i+1;
            sum += freeTimes.get(j);
            if(windowSize > k+1) {
                sum -= freeTimes.get(i);
                ans = Math.max(ans, sum);
                i++;
                j++;
            } else {
                ans = Math.max(ans, sum);
                j++;
            }
        } 
        return ans;
    }
}