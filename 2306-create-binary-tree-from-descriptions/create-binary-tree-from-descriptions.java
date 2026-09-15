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
    public TreeNode createBinaryTree(int[][] descriptions) {
        
        Map<Integer, TreeNode> hm = new HashMap<>();
        Map<Integer, Integer> identifyRoot = new HashMap<>();

        for(int[] curr : descriptions) {
            int parent = curr[0];
            int child  = curr[1];
            int isLeft = curr[2];

            if(!hm.containsKey(parent)) {
                hm.put(parent, new TreeNode(parent));
            }

            if(!hm.containsKey(child)) {
                hm.put(child, new TreeNode(child));
            }

            if(isLeft == 1) {
                hm.get(parent).left = hm.get(child);
            } else {
                hm.get(parent).right = hm.get(child);
            }

            if(identifyRoot.getOrDefault(parent, 0) != -1) {
                identifyRoot.put(parent, 1);
            }

            identifyRoot.put(child, -1);
        }

        int rootValue = -1;
        for(int key : identifyRoot.keySet()) {
            if(identifyRoot.get(key) == 1) {
                rootValue = key;
                break;
            }
        }

        return hm.get(rootValue);

    }
}