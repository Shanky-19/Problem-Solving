/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Approach-1 (Convert tree to graph)
//T.C : O(n) - visiting all nodes
//S.C : O(n) - storing all nodes in graph
public class Solution {

    public void convert(TreeNode current, int parent, Map<Integer, List<Integer>> adj) {
        if (current == null) {
            return;
        }

        if (parent != -1) {
            adj.computeIfAbsent(current.val, k -> new ArrayList<>()).add(parent);
        }

        if (current.left != null) {
            adj.computeIfAbsent(current.val, k -> new ArrayList<>()).add(current.left.val);
        }
        if (current.right != null) {
            adj.computeIfAbsent(current.val, k -> new ArrayList<>()).add(current.right.val);
        }
        convert(current.left, current.val, adj);
        convert(current.right, current.val, adj);
    }

    public int amountOfTime(TreeNode root, int start) {
        
        /*
        Map<Integer, List<Integer>> adj = new HashMap<>();
        convert(root, -1, adj);

        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int minutes = 0;

        while (!que.isEmpty()) {
            int n = que.size();

            while (n-- > 0) {
                int curr = que.poll();

                for (int ngbr : adj.getOrDefault(curr, Collections.emptyList())) {
                    if (!visited.contains(ngbr)) {
                        que.add(ngbr);
                        visited.add(ngbr);
                    }
                }
            }
            minutes++;
        }

        return minutes - 1;
        */

        // One pass solution
        dfs(root, start);
        return result;
        
    }
    int result = Integer.MIN_VALUE;
    private int dfs(TreeNode root, int start) {
        if(root == null) {
            return 0;
        }

        int lh = dfs(root.left, start);
        int rh = dfs(root.right, start);

        if(root.val == start) {
            result = Math.max(lh, rh);
            return -1;
        } else if(lh >=0 && rh >=0) {
            return Math.max(lh, rh) + 1;
        } else {
            int d = Math.abs(lh) + Math.abs(rh);
            result = Math.max(result, d);
            return Math.min(lh, rh) - 1;
        }

    }
}