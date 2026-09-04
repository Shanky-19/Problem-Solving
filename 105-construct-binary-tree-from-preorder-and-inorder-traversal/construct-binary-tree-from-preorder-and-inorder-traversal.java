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
    public TreeNode buildTreeHelper(int[] preorder,int[] inorder,int psi,int pei,int isi,int iei){
        if(psi > pei){
            return null;
        }
        int idx = isi;
        while(preorder[psi] != inorder[idx]){
            idx++;
        }
        int countOfLeftSubtreeElements = idx - isi;
        
        TreeNode root = new TreeNode(preorder[psi]);

        root.left = buildTreeHelper(preorder,inorder,psi+1,psi+countOfLeftSubtreeElements,isi,idx-1);

        root.right = buildTreeHelper(preorder,inorder,psi+countOfLeftSubtreeElements+1,pei,idx+1,iei);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTreeHelper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);

        return root;
    }
}