//Using simple DFS in map(adjaceny list)
//T.C : O(n) - Visiting all n nodes once.
//S.C : O(n) - stored in map
public class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();

    public int[] restoreArray(int[][] adjacentPairs) {
        for (int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];

            if(!adj.containsKey(x)) {
                adj.put(x, new ArrayList<>());
            }
            adj.get(x).add(y);


            if(!adj.containsKey(y)) {
                adj.put(y, new ArrayList<>());
            }
            adj.get(y).add(x);
        }

        int root = 0;
        for (int num : adj.keySet()) {
            if (adj.get(num).size() == 1) {
                root = num;
                break;
            }
        }

        int[] result = new int[adj.size()];
        dfs(root, Integer.MAX_VALUE, result, 0);
        return result;
    }

    private void dfs(int node, int prev, int[] result, int i) {
        result[i] = node;
        for (int neighbor : adj.get(node)) {
            if (neighbor != prev) {
                dfs(neighbor, node, result, i + 1);
            }
        }
    }
}