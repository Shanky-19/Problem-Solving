class Pair {
    int val;
    int idx ;

    public Pair (int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class StockSpanner {
    LinkedList<Pair> stack;
    int index = 0;
    public StockSpanner() {
        stack = new LinkedList<>();
    }
    
    public int next(int price) {
        while (stack.size() > 0 && stack.peek().val <= price) {
            stack.pop();
        }
        int stockSpan = 0;
        if(stack.size() == 0) {
            stockSpan = (index+1);
        } else {
            stockSpan = (index-stack.peek().idx);
        }
        stack.push(new Pair(price,index));
        index++;
        return stockSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */