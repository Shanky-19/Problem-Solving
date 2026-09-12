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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while(q.size() > 0) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode front = q.poll();

                if(front.left == null && front.right == null) {
                    return depth;
                }

                if(front.left != null) {
                    q.offer(front.left);
                }

                if(front.right != null) {
                    q.offer(front.right);
                }
            }     
            depth++;     
        }
        return depth;
    }
}