class Solution {

    class Pair implements Comparable<Pair>{
        int node;
        int wt;

        public Pair(int node,int wt) {
            this.node = node;
            this.wt = wt;
        }

        public int compareTo(Pair p) {
            if(this.wt == p.wt) {
                return this.node - p.node;
            }
            return this.wt - p.wt;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, 2*w));
        }


        // apply dijkstra's Algo 
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        pq.add(new Pair(0, 0)); // wt to source and source
        while(pq.size() > 0) {
            // r m* w a*
            Pair p = pq.remove();

            int node = p.node;
            int d = p.wt;
            for(Pair nbr : graph.get(node)) {
                int dest = nbr.node;
                int dist = nbr.wt;
                if(result[dest] > d + dist) {
                    result[dest] = d + dist;
                    pq.add(new Pair(dest, d + dist));
                }
            }
        }
        if(result[n-1] == Integer.MAX_VALUE) {
            return -1;
        }
        return result[n-1];
    }
}