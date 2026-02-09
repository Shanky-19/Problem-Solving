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
    public void inorder(TreeNode node, List<Integer> vals) {
        if(node == null) {
            return;
        }
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }
    public TreeNode build(List<Integer> vals, int low, int high) {
        if(low > high) {
            return null;
        }
        int mid = low + (high-low)/2;
        TreeNode node = new TreeNode(vals.get(mid));
        node.left  = build(vals, low, mid - 1);
        node.right = build(vals, mid + 1, high);
        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        return build(vals, 0, vals.size() - 1);
    }
}