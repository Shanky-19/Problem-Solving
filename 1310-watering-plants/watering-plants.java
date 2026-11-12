class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int step = 0;
        int capRem = capacity;

        for(int i=0; i<n; i++){
            step++;
            capRem -= plants[i];
            
            if(i != n-1 && plants[i+1] > capRem){
                step += (i+1)*2;
                capRem = capacity;
            }
        }
        return step;
    }
}