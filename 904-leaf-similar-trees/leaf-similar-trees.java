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

    private void dfs(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            ans.add(root.val);
        }

        dfs(root.left, ans);
        dfs(root.right, ans);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        dfs(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        dfs(root2, list2);

        return list1.equals(list2);
    }
}