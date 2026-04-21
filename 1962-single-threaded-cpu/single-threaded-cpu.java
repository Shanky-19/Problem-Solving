class Solution {

    class Pair implements Comparable<Pair> {
        int duration;
        int idx;

        public Pair (int duration, int idx) {
            this.duration = duration;
            this.idx = idx;
        }

        public int compareTo(Pair p) {
            if(this.duration == p.duration) {
                return this.idx - p.idx;
            }
            return this.duration - p.duration;
        }

        public String toString() {
            return (this.duration + " -> " + this.idx);
        }

    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];

        for(int i=0;i<n;i++) {
            // enque-time, processing-time, idx
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        Arrays.sort(sortedTasks, (a, b) -> {
            return a[0]-b[0];
        });

        int currentTime = 0;
        int i = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] ans = new int[n];
        int idx = 0;
        while (i < n || !pq.isEmpty()) {

            if(pq.size() == 0 && currentTime <= sortedTasks[i][0]) {
                currentTime = sortedTasks[i][0];
            }
            while(i<n && sortedTasks[i][0] <= currentTime) {
                pq.add(new Pair(sortedTasks[i][1], sortedTasks[i][2]));
                i++;
            }
            // System.out.println(currentTime + " -> " + (pq));
            
            Pair p = pq.remove();
            currentTime += p.duration;
            ans[idx] = (p.idx);
            idx++;
        }

        return ans;
    }
}