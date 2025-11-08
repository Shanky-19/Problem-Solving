/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();

        queue.addLast(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Node> list = new ArrayList<>(queue);
            for(int i=0;i<list.size()-1;i++) {
                list.get(i).next = list.get(i+1);
            }
            list.get(list.size()-1).next = null;
            while(size-- > 0) {
                // r m* w a*

                // r
                Node node = queue.removeFirst();

                // a*
                if(node.left != null) {
                    queue.addLast(node.left);
                }
                if(node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return root;
    }
}