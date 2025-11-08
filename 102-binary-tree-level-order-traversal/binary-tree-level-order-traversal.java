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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        // removeFirst() and addLast()
        
        queue.addLast(root);
        
        while(queue.size() > 0){
            List<Integer> al = new ArrayList<>();
            int size = queue.size();
            while(size-- >0){
                TreeNode front = queue.removeFirst();
                al.add(front.val);
                
                if(front.left != null){
                    queue.addLast(front.left);
                }
                
                if(front.right != null){
                    queue.addLast(front.right);
                }
            }
            ans.add(al);
        }
        
        return ans;
    }
}
