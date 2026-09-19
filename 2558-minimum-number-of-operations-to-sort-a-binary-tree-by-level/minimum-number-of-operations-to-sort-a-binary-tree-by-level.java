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
    public int countMinSwapsToSort(List<Integer> list) {
        int swaps = 0;
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        Map<Integer, Integer> mp = new HashMap<>(); // nums[i] -> i
        for (int i = 0; i < list.size(); i++) {
            mp.put(list.get(i), i);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(sortedList.get(i))) {
                continue; // no swap required
            }

            int currIdx = mp.get(sortedList.get(i));
            mp.put(list.get(i), currIdx);
            mp.put(list.get(currIdx), i);
            Collections.swap(list, currIdx, i);
            swaps++;
        }

        return swaps;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        int result = 0;

        while (!que.isEmpty()) {
            int n = que.size(); // total nodes in the current level
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode temp = que.poll();
                list.add(temp.val);

                if (temp.left != null) {
                    que.add(temp.left);
                }

                if (temp.right != null) {
                    que.add(temp.right);
                }
            }

            result += countMinSwapsToSort(list);
        }

        return result;
    }
}