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
    public String tree2str(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        ans.append(root.val);
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        
        if(!right.equals("")) {
            ans.append('(');
            ans.append(left);
            ans.append(')');
            ans.append('(');
            ans.append(right);
            ans.append(')');
        } else if(!left.equals("")) {
            ans.append('(');
            ans.append(left);
            ans.append(')');
        }

        return ans.toString();
    }
}