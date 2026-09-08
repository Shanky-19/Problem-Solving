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

    private String solve(TreeNode root, Map<String, Integer> map, List<TreeNode> ans) {
        if(root == null) {
            return "N";
        }

        String str = root.val + "," + solve(root.left, map, ans) + "," + solve(root.right, map, ans);
        if(map.containsKey(str) && map.get(str) == 1) {
            ans.add(root);
        }

        map.put(str, map.getOrDefault(str, 0) + 1);

        return str;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        solve(root, map, ans);
        return ans;
    }
}