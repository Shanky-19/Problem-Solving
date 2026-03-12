class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        while (i < n && j < n) {
            int pop = popped[j];
            int push = pushed[i];

            if(stack.size() == 0) {
                stack.push(push);
                i++;
            } else {
                if(stack.peek() == pop) {
                    stack.pop();
                    j++;
                } else {
                    stack.push(push);
                    i++;
                }
            }
        }
        
        while(j < n) {
            if(stack.peek() != popped[j]) {
                return false;
            }
            stack.pop();
            j++;
        }

        return stack.size() == 0;
    }
}