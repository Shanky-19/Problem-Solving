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

    static class Pair {
        int balance;
        int moves;

        Pair(int balance, int moves) {
            this.balance = balance;
            this.moves = moves;
        }
    }

    public static int distributeCoins(TreeNode root) {
        Pair ans = solve(root);
        return ans.moves;
    }

    private static Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        int moves = left.moves + right.moves
                  + Math.abs(left.balance)
                  + Math.abs(right.balance);

        int balance = left.balance + right.balance + root.val - 1;

        return new Pair(balance, moves);
    }
}