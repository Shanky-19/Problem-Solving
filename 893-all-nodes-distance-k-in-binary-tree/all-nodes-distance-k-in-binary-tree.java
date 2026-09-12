/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private Map<TreeNode, TreeNode> parent = new HashMap<>();

    private void addParent(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            parent.put(root.left, root);
        }
        addParent(root.left);

        if (root.right != null) {
            parent.put(root.right, root);
        }
        addParent(root.right);
    }

    private void collectKDistanceNodes(TreeNode target, int k, List<Integer> result) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {

            int n = queue.size();

            if (k == 0) {
                break;
            }

            while (n-- > 0) {
                // r m* w a*

                TreeNode curr = queue.poll();

                visited.add(curr.val);

                // Left child
                if (curr.left != null && !visited.contains(curr.left.val)) {
                    queue.offer(curr.left);
                }

                // Right child
                if (curr.right != null && !visited.contains(curr.right.val)) {
                    queue.offer(curr.right);
                }

                // Parent
                if (parent.containsKey(curr)
                        && !visited.contains(parent.get(curr).val)) {

                    queue.offer(parent.get(curr));
                }
            }

            k--;
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        addParent(root);
        collectKDistanceNodes(target, k, result);
        return result;
    }
}