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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(queue.size() > 0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.removeFirst();
                if(i == size-1){
                    ans.add(node.val);
                }

                if(node.left != null){
                    queue.addLast(node.left);
                }

                if(node.right != null){
                    queue.addLast(node.right);
                }
            }
        }
        return ans;
    }
}