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
    public int maxLevelSum(TreeNode root) {
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 0;
        int maxSum = Integer.MIN_VALUE;
        int lev = 0;
        while(queue.size() > 0){
            int size = queue.size();
            int tempSum = 0;
            level++;
            while(size-- > 0){
                // r m* w a*
                TreeNode front = queue.removeFirst();
                tempSum += front.val;

                if(front.left != null){
                    queue.addLast(front.left);
                }
                if(front.right != null){
                    queue.addLast(front.right);
                }
            }
            if(tempSum > maxSum){
                maxSum = tempSum;
                lev = level;
            }
        }
        return lev;
    }
}