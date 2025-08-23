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

    class Pair2 implements Comparable<Pair2>{
        int d;
        int p;

        public Pair2(int d, int p) {
            this.d = d;
            this.p = p;
        }

        public int compareTo(Pair2 pair) {
            return this.d - pair.d;
        }

        public String toString() {
            return ("d : " + d + " p : " + p);
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
        /*
        int m = worker.length;
        int n = profit.length;
        int ans = 0;
        PriorityQueue<Pair> pq 
        = new PriorityQueue<>();

        for(int i=0;i<n;i++) {
            pq.add(new Pair(profit[i], difficulty[i]));
        }
        // this is needed becoz Arrays.sort() 
        // doesn't work on primitive types arr
        // if comparator (Collections.reverOrder) is provided.
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
        */


        // Approach 2 : Binary Search
        /*
        int m = worker.length;
        int n = profit.length;
        int ans = 0;
        List<Pair2> sortedByDiff = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int diff = difficulty[i];
            int prof = profit[i];
            sortedByDiff.add(new Pair2(diff, prof));
        }
        Collections.sort(sortedByDiff);
        // store max-profit till now for each idx
        for(int i=1;i<n;i++) {
            Pair2 p1 = sortedByDiff.get(i-1);
            Pair2 p2 = sortedByDiff.get(i);

            if(p1.p > p2.p) {
                p2.p = p1.p;
                sortedByDiff.set(i, p2);
            }
        }
        // System.out.println(sortedByDiff);
        for(int i=0;i<m;i++) {
            int ability = worker[i];

            int idx = binarySearch(sortedByDiff, ability);
            if(idx != -1) {
                int maxProfitTillIdx = sortedByDiff.get(idx).p;
                ans += maxProfitTillIdx;
            }
        }
        return ans;
        */


        // Approach 3 : Most optimized
        int m = worker.length;
        int n = profit.length;
        int ans = 0;
        List<Pair2> sortedByDiff = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int diff = difficulty[i];
            int prof = profit[i];
            sortedByDiff.add(new Pair2(diff, prof));
        }
        Collections.sort(sortedByDiff);
        Arrays.sort(worker);
        int maxProfit = 0;
        int i = 0; // for worker
        int j = 0; // for diff 
        while (i < m && j < n) {
            int ability = worker[i];
            while(j < n && ability >= sortedByDiff.get(j).d) {
                Pair2 pair = sortedByDiff.get(j);
                int diff = pair.d;
                int prof = pair.p;

                maxProfit = Math.max(maxProfit, prof);
                j++;
            }
            ans += maxProfit;
            i++;
        }

        while(i < m) {
            ans += maxProfit;
            i++;
        }
        return ans;
        
    }

    private int binarySearch(List<Pair2> list, int ability) {
        int low = 0;
        int high = list.size()-1;
        int idx = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;

            Pair2 pair = list.get(mid);
            if(pair.d > ability) {
                high = mid - 1;
            }else {
                idx = mid;
                low = mid + 1;
            }
        }
        return idx;
    }

    
}