class Solution {

    // TLE -> Most Intuitive
    /*
    public int helper(int idx,int prevEndTime,int[][] events,int k){
        if(k == 0 || idx == events.length){
            return 0;
        }
        int ans = 0;
        if(prevEndTime < 0){
            // not pick
            int ans1 = helper(idx+1,prevEndTime,events,k);

            // pick
            int endTime=events[idx][1];
            int ans2 = helper(idx+1,endTime,events,k-1) + events[idx][2];

            ans = Math.max(ans1,ans2);
        }else{
            // not pick
            int ans1 = helper(idx+1,prevEndTime,events,k);

            // pick
            int ans2 = 0;
            int startTime=events[idx][0];
            int endTime=events[idx][1];
            if(prevEndTime < startTime){
                ans2 = events[idx][2] + helper(idx+1,endTime,events,k-1);
            }
            ans = Math.max(ans1,ans2);
        }
        return ans;
    }
    */


    public int helper(int idx,int[][] events,int k,int[][] dp){
        if(k == 0 || idx == events.length){
            return 0;
        }
        if(dp[idx][k] != -1){
            return dp[idx][k];
        }
        int ans = helper(idx+1,events,k,dp);
        if(k > 0){
            // linear search -> can be optimized to binary search
            
            /*
            int nextIdx = events.length;
            for(int j=idx+1;j<events.length;j++){
                if(events[j][0] > events[idx][1]){
                    nextIdx = j;
                    break;
                }
            }
            ans = Math.max(ans,helper(nextIdx,events,k-1,dp)+events[idx][2]);
            */
            
            // int nextIdx = events.length;
            int s = idx+1;
            int e = events.length-1;
            while(s <= e){
                int mid = (s+e)/2;
                if(events[mid][0] > events[idx][1]){
                    // nextIdx = mid;
                    e = mid-1;
                }else{
                    s = mid+1;
                }
            }
            ans = Math.max(ans,helper(s,events,k-1,dp)+events[idx][2]);
        }
        
        return dp[idx][k] = ans;
    }

    public int maxValue(int[][] events, int k) {
        
        // TLE 
        /*
        int idx = 0;
        int prevEndTime = -1;
        Arrays.sort(events,(a,b)->{
            return a[1]-b[1];
        });
        int ans = helper(idx,prevEndTime,events,k);
        return ans;
        */
// ============================================================================================
        // we cannot store (prevEndTime <= 10^9) so we have to element the varying param 
        // prevEndTime to store into DP
        int idx = 0;

        // sort as per starting time
        Arrays.sort(events,(a,b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        int[][] dp = new int[events.length][k+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = helper(idx,events,k,dp);
        return ans;
// ===========================================================================================
    }
}