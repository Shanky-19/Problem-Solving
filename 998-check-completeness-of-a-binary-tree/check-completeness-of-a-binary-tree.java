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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean sawNullInPast = false;

        while(q.size() > 0) {
            TreeNode front = q.poll();

            if(front == null) {
                sawNullInPast = true; 
            } else {
                if(sawNullInPast) {
                    return false;
                }

                q.offer(front.left);
                q.offer(front.right);
            }
        }
        return true;
    }
}