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
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftMax = helper(root.left);
        int rightMax = helper(root.right);

        ans = Math.max(ans, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }
}