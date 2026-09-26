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

    public TreeNode helper(int[] preorder, int[] postorder,
                            int presi,int preei,int postsi,int postei) {
        if(presi > preei){
            return null;
        }
        TreeNode root = new TreeNode(preorder[presi]);

        if(presi == preei){
            return root;
        }
        int idx = postsi;
        while(presi+1 < preorder.length 
                && postorder[idx] != preorder[presi+1]){
            idx++;
        }

        int countOfLeftSubtreeNodes = idx - postsi + 1;

        root.left = helper(preorder,postorder,presi+1,
                            presi+countOfLeftSubtreeNodes,postsi,idx);
        root.right = helper(preorder,postorder,
                            presi+countOfLeftSubtreeNodes+1,preei,idx+1,postei-1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, 
                                    int[] postorder) {
        TreeNode root = helper(preorder,postorder,0,preorder.length-1,
                                0,postorder.length-1);
        return root;
    }
}