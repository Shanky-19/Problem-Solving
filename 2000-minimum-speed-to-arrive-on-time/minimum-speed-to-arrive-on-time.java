class Solution {

    public double check(int speed,int[] dist){
        double time = 0.0;

        for(int i=0;i<dist.length;i++){
            int d = dist[i];
            if(i == dist.length-1){
                time += (1.0*d)/speed;
            }else{
                time += Math.ceil((1.0*d)/speed);
            }
        }

        return time;
    } 

    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = (int)Math.pow(10,7);
        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            double time = check(mid,dist);
            if(time <= hour){
                ans = mid;
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return ans;
    }
}