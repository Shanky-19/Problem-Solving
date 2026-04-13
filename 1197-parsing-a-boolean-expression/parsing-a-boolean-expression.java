class Solution {

    private char solveOp(char op, List<Character> values) {
        if (op == '!') {
            return values.get(0) == 't' ? 'f' : 't';
        }
        if (op == '&') {
            for (char ch : values) {
                if (ch == 'f') {
                    return 'f';
                }
            }
            return 't';
        }
        if (op == '|') {
            for (char ch : values) {
                if (ch == 't') {
                    return 't';
                }
            }
            return 'f';
        }
        return 't';
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == ',') {
                continue;
            }

            if (c == ')') {
                List<Character> values = new ArrayList<>();

                while (stack.peek() != '(') {
                    values.add(stack.pop());
                }

                stack.pop(); // remove '('
                char op = stack.pop(); // operator before '('

                stack.push(solveOp(op, values));
            } else {
                stack.push(c);
            }
        }
        return stack.peek() == 't';
    }
}