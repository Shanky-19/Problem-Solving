class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for(int i=0;i<n;i++) {
            String str = tokens[i];
            if(str.equals("/")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2/op1);
            } else if(str.equals("*")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2*op1);
            } else if(str.equals("+")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2+op1);
            } else if(str.equals("-")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2-op1);
            } else {
                int operand = Integer.parseInt(str);
                stack.push(operand);
            }
        }
        return stack.pop();
    }
}