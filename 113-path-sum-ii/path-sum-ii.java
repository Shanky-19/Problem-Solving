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
 
    private void solve(TreeNode root, int currSum, List<Integer> al,
                        List<List<Integer>> ans, int targetSum) {
        if(root == null) {
            return;
        }

        int tempCurrSum = currSum + root.val;
        al.add(root.val);
        if(root.left == null && root.right == null && tempCurrSum == targetSum) {
            ans.add(new ArrayList<>(al));
            return;
        }

        solve(root.left, currSum + root.val, 
                        new ArrayList<>(al), ans, targetSum);
        solve(root.right, currSum + root.val, 
                        new ArrayList<>(al), ans, targetSum);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int currSum = 0;
        List<Integer> al = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(root, currSum, al, ans, targetSum);
        return ans;
    }
}