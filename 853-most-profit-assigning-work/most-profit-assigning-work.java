class Solution {

    class Pair implements Comparable<Pair>{
        int p;
        int d;

        public Pair(int p, int d) {
            this.p = p;
            this.d = d;
        }

        public int compareTo(Pair pair) {
            return pair.p - this.p;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // brute force
        /*
        int m = worker.length;
        int n = profit.length;
        int ans = 0;
        for(int i=0;i<m;i++) {
            int ability = worker[i];
            int maxProfit = 0;
            for(int j=0;j<n;j++) {
                if(ability >= difficulty[j]) {
                    maxProfit = Math.max(maxProfit, profit[j]);
                }
            }
            ans += maxProfit;
        }
        return ans;
        */

        // Approach 1 : Max-Heap
        int m = worker.length;
        int n = profit.length;
        int ans = 0;
        PriorityQueue<Pair> pq 
        = new PriorityQueue<>();

        for(int i=0;i<n;i++) {
            pq.add(new Pair(profit[i], difficulty[i]));
        }

        Integer[] workers = new Integer[m];
        for(int i=0;i<m;i++) {
            workers[i] = worker[i];
        }

        Arrays.sort(workers, Collections.reverseOrder());

        for(int i=0;i<m;i++) {
            int ability = workers[i];
            while(pq.size() > 0 && pq.peek().d > ability) {
                pq.poll();
            }
            if(pq.size() > 0) {
                Pair pair = pq.peek();
                ans += pair.p;
            }
        }
        return ans;
        
    }

    
}