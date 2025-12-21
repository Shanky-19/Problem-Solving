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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int n = nums.length;
        TreeNode root = helper(nums,0, n-1);
        return root;
    }

    private TreeNode helper(int[] nums,int s, int e) {
        if(s > e) {
            return null;
        }
        // if(s == e) {
        //     return new TreeNode(nums[s]);
        // }
        int mid = (s+e)/2;

        TreeNode rootLeft = helper(nums, s, mid-1);
        TreeNode rootRight = helper(nums, mid+1, e);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = rootLeft;
        root.right = rootRight;
        return root;
    }
}