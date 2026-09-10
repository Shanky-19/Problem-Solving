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
    int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        solve(root);
        return maxLength;
    }

    public int[] solve(TreeNode root){
        if(root == null){
            return new int[]{-1,-1};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        maxLength = Math.max(maxLength,Math.max(left[1]+1,right[0]+1));

        int[] ans = new int[2];
        ans[0] = 1 + left[1];
        ans[1] = 1 + right[0];
        return ans;
    }
}