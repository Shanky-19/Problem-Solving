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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        TreeNode curr = root;
        TreeNode prev = null;
        List<Integer> ans = new ArrayList<>();
        while(curr != null) {
            if(curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                prev = curr.left;

                while(prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return ans;
    }
}