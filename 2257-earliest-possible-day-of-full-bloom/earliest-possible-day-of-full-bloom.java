class Solution {

    class Pair implements Comparable<Pair>{
        int pt;
        int gt;

        public Pair (int pt, int gt) {
            this.pt = pt;
            this.gt = gt;
        }

        public int compareTo(Pair p) {
            return p.gt - this.gt;
        }
    }

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            Pair p = new Pair(plantTime[i], growTime[i]);
            pq.add(p);
        }

        int currentDay = 0;
        int maxDay = 0;
        while (pq.size() > 0) {
            Pair p = pq.remove();
            int pt = p.pt;
            int gt = p.gt;

            maxDay = Math.max(maxDay, currentDay + pt + gt);
            currentDay += pt;
        }

        return maxDay;
    }
}