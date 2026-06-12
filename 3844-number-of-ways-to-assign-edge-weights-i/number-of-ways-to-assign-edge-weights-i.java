class Solution {
    int mod = 1000000007;

    private long binaryExponential(int a, int b) {
        if(b == 0) {
            return 1;
        }
        long x = binaryExponential(a, b/2);
        long ans  = (x * x) % mod;
        if(b % 2 == 1) {
            ans = (ans * a)%mod;
        }
        return ans;
    }

    public int assignEdgeWeights(int[][] edges) {
        /**
            Lets say max depth is d -> here d is edges
            now for each edge we have 2 options : 2^d options total
            So out of 2^d option helf will result in even sum and half in odd
            so our answer = 2 ^ (d-1);
        */
        int n = edges.length + 1;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i=1;i<=n;i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int d = findMaxDepth(1, adj, -1); // start, graph/tree, parent
        long total = binaryExponential(2, d-1);
        return (int) total;
    }

    private int findMaxDepth(int node, 
        Map<Integer, List<Integer>> adj, int parent) {
        
        int depth = 0;
        for(int nbr : adj.get(node)) {
            if(nbr == parent) {
                continue;
            }
            depth = Math.max(depth, 1 + findMaxDepth(nbr, adj, node));
        }
        return depth;
    }
}