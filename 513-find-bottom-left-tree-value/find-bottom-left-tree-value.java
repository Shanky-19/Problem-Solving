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
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = Integer.MIN_VALUE;
        while(q.size() > 0) {
            int i = 0;
            int size = q.size();
            while(i < size) {
                
                TreeNode front = q.poll();

                if(i == 0) {
                    ans = front.val;
                }

                if(front.left != null) {
                    q.offer(front.left);
                }

                if(front.right != null) {
                    q.offer(front.right);
                }

                i++;
            }
        }
        return ans;
    }
}