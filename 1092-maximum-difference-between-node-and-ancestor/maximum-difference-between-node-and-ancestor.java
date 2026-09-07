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
class Solution {
    int ans = 0;

    class Pair {
        int min;
        int max;

        public Pair (int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private Pair solve(TreeNode root) {
        if(root == null) {
            return new Pair (Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        if(root.left == null && root.right == null) {
            return new Pair(root.val, root.val);
        }

        Pair leftPair = solve(root.left);
        Pair rightPair = solve(root.right);

        int min = Math.min(leftPair.min, rightPair.min);
        int max = Math.max(leftPair.max, rightPair.max);

        ans = Math.max(Math.abs(min-root.val), ans);
        ans = Math.max(Math.abs(max-root.val), ans);

        Pair p = new Pair(Math.min(min, root.val), Math.max(max, root.val));
        return p;
    }

    public int maxAncestorDiff(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Pair leftPair = solve(root.left);
        Pair rightPair = solve(root.right);
        
        int min = Math.min(leftPair.min, rightPair.min);
        int max = Math.max(leftPair.max, rightPair.max);

        ans = Math.max(Math.abs(min-root.val), ans);
        ans = Math.max(Math.abs(max-root.val), ans);

        Pair p = new Pair(Math.min(min, root.val), Math.max(max, root.val));
        return ans;
    }
}