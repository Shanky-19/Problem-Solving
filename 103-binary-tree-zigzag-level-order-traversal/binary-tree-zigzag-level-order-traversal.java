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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null){
            return new ArrayList<>();
        }
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        
        List<List<Integer>> ans = new ArrayList<>();
        boolean leftToRight = true;
        while(queue.size() > 0){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size-- > 0){
                TreeNode front = queue.removeFirst();
                
                // if(leftToRight){
                //     list.add(front.val);
                // }else{
                //     list.add(0,front.val);
                // }
                list.add(front.val);
                
                if(front.left != null){
                    queue.add(front.left);
                }
                
                if(front.right != null){
                    queue.add(front.right);
                }
                
            }
            if(!leftToRight) {
                Collections.reverse(list);
            }
            ans.add(list);
            leftToRight = (leftToRight) ? false : true;
        }
        return ans;
    }
}