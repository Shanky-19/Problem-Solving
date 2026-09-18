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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSum = root.val;

        while (!queue.isEmpty()) {
            int n = queue.size();
            int nextLevelSum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();

                // Update current node value
                curr.val = levelSum - curr.val;

                int siblingSum = 
                                (curr.left != null ? curr.left.val : 0) +
                                (curr.right != null ? curr.right.val : 0);

                // Process left child
                if (curr.left != null) {
                    nextLevelSum += curr.left.val;
                    curr.left.val = siblingSum;
                    queue.add(curr.left);
                }

                // Process right child
                if (curr.right != null) {
                    nextLevelSum += curr.right.val;
                    curr.right.val = siblingSum;
                    queue.add(curr.right);
                }
            }

            // Move to the next level
            levelSum = nextLevelSum;
        }

        return root;
    }
}