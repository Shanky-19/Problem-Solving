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
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int hl = height(root.left);
        int hr = height(root.right);

        return Math.max(hl,hr) + 1;

    }
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ans1 = countNodes(root.left);
        int ans2 = countNodes(root.right);
        return ans1+ans2+1;
    }
}