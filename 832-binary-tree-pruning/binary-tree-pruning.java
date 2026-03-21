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
    
    public boolean canPrune(TreeNode root){
        if(root == null){
            return true;
        }
        
        boolean canLeftPrune = canPrune(root.left);
        boolean canRightPrune = canPrune(root.right);
        
        if(root.val == 0 && canLeftPrune && canRightPrune){
            return true;
        }
        return false;
    }
    
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        
        TreeNode leftRoot = pruneTree(root.left);
        TreeNode rightRoot = pruneTree(root.right);
        
        boolean canLeftPrune = canPrune(root.left);
        boolean canRightPrune = canPrune(root.right);
        
        if(canLeftPrune && canRightPrune && root.val == 0){
            return null;
        }else if(canLeftPrune && canRightPrune){
            root.left = null;
            root.right = null;
        }else if(canLeftPrune){
            root.left = null;
        }else if(canRightPrune){
            root.right = null;
        }
        
        return root;
    }
}