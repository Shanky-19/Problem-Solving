/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public void serializeHelper(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);

    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }

    int i = 0; // to interate over data array
    public TreeNode deserializeHelper(String[] data) {
        if(data[i].equals("null")){
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(data[i]));
        i++;
        node.left = deserializeHelper(data);
        node.right = deserializeHelper(data);

        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) {
        String[] data = str.split(",");
        TreeNode root = deserializeHelper(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));