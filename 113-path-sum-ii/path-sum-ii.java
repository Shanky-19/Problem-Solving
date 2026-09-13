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

    private void solve(TreeNode root, int targetSum, 
                    List<Integer> al, List<List<Integer>> ans) {
        if(root == null) {
            return;
        }
        al.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum) {
            ans.add(new ArrayList<>(al));
        }
        
        solve(root.left, targetSum - root.val, al, ans);
        solve(root.right, targetSum - root.val, al, ans);

        al.remove(al.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        solve(root, targetSum, al, ans);
        return ans;
    }
}