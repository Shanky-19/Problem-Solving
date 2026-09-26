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
    private int idx = 0;

    private TreeNode solve(String traversal, int depth) {
        if (idx >= traversal.length()) {
            return null;
        }

        int j = idx;

        while (j < traversal.length() && traversal.charAt(j) == '-') {
            j++;
        }

        int dash = j - idx;

        if (dash != depth) {
            return null;
        }

        idx += dash;

        int value = 0;
        while (idx < traversal.length() 
                && Character.isDigit(traversal.charAt(idx))) {
            value = value * 10 + (traversal.charAt(idx) - '0');
            idx++;
        }

        TreeNode root = new TreeNode(value);

        root.left = solve(traversal, depth + 1);
        root.right = solve(traversal, depth + 1);

        return root;
    }

    public TreeNode recoverFromPreorder(String traversal) {
        idx = 0;
        return solve(traversal, 0);
    }
}