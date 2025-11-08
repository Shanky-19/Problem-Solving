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
        if(root == null){
            return null;
        }
        
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        
        while(queue.size() > 0){
            int size = queue.size();
            

            for(int i=0;i<size;i++){
                Node removed = queue.removeFirst();
                if(i == size-1){
                    removed.next = null;
                }else{
                    removed.next = queue.getFirst();    
                }
             
                
                if(removed.left != null){
                    queue.addLast(removed.left);    
                }
                if(removed.right != null){
                    queue.addLast(removed.right);    
                }
            }
        }
        
        return root;
    }
}