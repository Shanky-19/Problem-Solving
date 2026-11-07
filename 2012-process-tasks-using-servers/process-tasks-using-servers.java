
class Solution {

    class Pair implements Comparable<Pair> {
        int server;
        int idx;

        Pair(int server, int idx) {
            this.server = server;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.server == p.server) {
                return Integer.compare(this.idx, p.idx);
            }
            return Integer.compare(this.server, p.server);
        }
    }

    class Pair2 implements Comparable<Pair2> {
        Pair p;
        long freeTime;

        Pair2(Pair p, long freeTime) {
            this.p = p;
            this.freeTime = freeTime;
        }

        @Override
        public int compareTo(Pair2 pair) {
            return Long.compare(this.freeTime, pair.freeTime);
        }
    }

    private void checkFreeAndAdd(
        PriorityQueue<Pair> pq,
        PriorityQueue<Pair2> pq2,
        long time
    ) {
        while (!pq2.isEmpty() && pq2.peek().freeTime <= time) {
            pq.offer(pq2.poll().p);
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(servers[i], i));
        }

        PriorityQueue<Pair2> pq2 = new PriorityQueue<>();

        int[] ans = new int[m];
        long time = 0;

        for (int t = 0; t < m; t++) {

            time = Math.max(time, (long)t);

            checkFreeAndAdd(pq, pq2, time);

            // If all servers are busy, jump to earliest free time
            if (pq.isEmpty()) {
                time = pq2.peek().freeTime;
                checkFreeAndAdd(pq, pq2, time);
            }

            Pair server = pq.poll();

            ans[t] = server.idx;

            pq2.offer(new Pair2(server, time + tasks[t]));
        }

        return ans;
    }
}
