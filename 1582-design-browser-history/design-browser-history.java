class BrowserHistory {

    class Node {
        String val;
        Node next;
        Node prev;

        public Node (String val, Node prev, Node next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public Node (String val) {
            this.val = val;
        }

    }

    Node curr;

    public BrowserHistory(String homepage) {
        Node head = new Node(homepage);
        curr = head;
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        node.prev = curr;
        curr.next = node;
        curr = curr.next;
    }
    
    public String back(int steps) {
        while(steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while(steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */