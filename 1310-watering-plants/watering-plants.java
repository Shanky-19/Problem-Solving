class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int step = 0;
        int capRem = capacity;

        for(int i=0; i<plants.length; i++){
            step++;
            capRem -= plants[i];
            
            if(i != plants.length-1 && plants[i+1] > capRem){
                step += (i+1)*2;
                capRem = capacity;
            }
        }
        return step;
    }
}