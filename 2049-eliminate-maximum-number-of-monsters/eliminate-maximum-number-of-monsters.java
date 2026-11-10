class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            pq.add((int)Math.ceil((double)dist[i]/speed[i]));
        }

        int count = 0;
        for(int t=0;t<n;t++) {
            int top = pq.remove();
            if(top <= t) {
                return count;
            }
            count++;
        }
        return count;
    }
}