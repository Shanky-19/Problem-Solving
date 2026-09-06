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

    private void addNodes(TreeNode root, int val) {
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        TreeNode newLeft = new TreeNode(val);
        TreeNode newRight = new TreeNode(val);
        root.left = newLeft;
        root.right = newRight;
        newLeft.left = tempLeft;
        newRight.right = tempRight;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currDepth = 1;
        while(q.size() > 0) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode front = q.poll();

                if(currDepth == depth - 1) {
                    addNodes(front, val);
                }

                if(front.left != null) {
                    q.offer(front.left);
                }

                if(front.right != null) {
                    q.offer(front.right);
                }
                

                
            }
            if(currDepth == depth-1) {
                break;
            }
            currDepth++;
        }
        return root;
    }
}