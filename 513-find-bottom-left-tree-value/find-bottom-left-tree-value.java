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
    int maxLevel = -1;
    int ans = Integer.MIN_VALUE;

    private void solve(TreeNode root, int currLevel) {
        if(root == null) {
            return;
        }

        if(currLevel > maxLevel) {
            maxLevel = currLevel;
            ans = root.val;
        }

        solve(root.left, currLevel+1);
        solve(root.right, currLevel+1);
    }


    public int findBottomLeftValue(TreeNode root) {
        int currLevel = 0;
        solve(root, currLevel);
        return ans;
    }
}