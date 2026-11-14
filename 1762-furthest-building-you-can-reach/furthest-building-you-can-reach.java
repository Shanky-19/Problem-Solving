class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;
        for(int i=1;i<n;i++){
            if(heights[i]>heights[i-1]){
                pq.add(heights[i]-heights[i-1]);
                if(pq.size()>ladders){
                    // we have to use bricks
                    bricks -= pq.poll();
                }
            }
            if(bricks<0) return i-1;
        }
        return n-1;
    }
}