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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(q.size() > 0) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while(size-- > 0) {
                TreeNode front = q.poll();

                max = Math.max(max, front.val);

                if(front.left != null) {
                    q.offer(front.left);
                }

                if(front.right != null) {
                    q.offer(front.right);
                }

            }
            ans.add(max);
        }
        return ans;
    }
}