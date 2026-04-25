//Approach - (DSU + map)
//T.C : O(n + m*alpha(n)), alpha(n) = inverse Ackermann function.
//S.C : O(n)
class Solution {

    private void union (int[] rank, int[] parent,int u, int v) {
        int parentU = find(u, parent);
        int parentV = find(v, parent);

        if(parentU == parentV) {
            return;
        } else if(rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else if(rank[parentV] > rank[parentU]) {
            parent[parentU] = parentV;
        } else {
            parent[parentU] = parentV;
            rank[parentV]++;
        }
    }

    private int find(int u, int[] parent) {
        if(u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u], parent);
    }


    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Union of allowedSwaps
        for (int[] edge : allowedSwaps) {
            union(rank, parent, edge[0], edge[1]);
        }

        // group -> (value -> freq)
        Map<Integer, Map<Integer, Integer>> groupFreq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i,parent);

            groupFreq.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> freqMap = groupFreq.get(root);

            freqMap.put(source[i], freqMap.getOrDefault(source[i], 0) + 1);
        }

        int hammingDistance = 0;

        for (int i = 0; i < n; i++) {
            int root = find(i,parent);
            Map<Integer, Integer> freqMap = groupFreq.get(root);

            if (freqMap.getOrDefault(target[i], 0) > 0) {
                freqMap.put(target[i], freqMap.get(target[i]) - 1);
            } else {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }
}