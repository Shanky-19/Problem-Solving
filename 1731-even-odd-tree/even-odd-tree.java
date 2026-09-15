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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while(q.size() > 0) {
            int size = q.size();
            TreeNode prev = null;
            while(size-- > 0) {

                TreeNode front = q.poll();

                if(level%2 == 0) {
                    if(front.val%2 == 0) {
                        return false;
                    }
                    if(prev != null && prev.val >= front.val) {
                        return false;
                    }
                    
                } else {
                    if(front.val%2 == 1) {
                        return false;
                    }

                    if(prev != null && prev.val <= front.val) {
                        return false;
                    }
                }
                prev = front;

                
                if(front.left != null) {
                    q.offer(front.left);
                }

                if(front.right != null) {
                    q.offer(front.right);
                }

            }
            level++;
        }

        return true;
    } 
}