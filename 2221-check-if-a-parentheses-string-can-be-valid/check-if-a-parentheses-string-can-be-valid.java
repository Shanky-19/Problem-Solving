class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> flexible = new Stack<>();

        for (int i=0;i<n;i++) {
            char ch = s.charAt(i);
            int lock = locked.charAt(i);

            if(ch =='(' && lock == '1') {
                // add to stack
                stack.push(i);
            } else if (ch == ')' && lock == '1') {
                // check in stack
                if(stack.size() > 0) {
                    stack.pop();
                } else if (flexible.size() > 0 
                    && flexible.peek() < i) {
                    // check in flexible
                    flexible.pop();
                } else {
                    return false;
                }
            } else {
                flexible.push(i);
            }
        }
        while (stack.size() > 0) {
            if(flexible.size() == 0) {
                return false;
            }
            int top = stack.pop();
            if(top > flexible.peek()) {
                return false;
            } else{
                flexible.pop();
            }
        }

        if(flexible.size()%2 != 0) {
            return false;
        }
        return true;
    }
}