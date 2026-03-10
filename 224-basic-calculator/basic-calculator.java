class Solution {

    private boolean isDigit (char ch) {
        if(ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    public int calculate(String s) {
        int number = 0;
        int result = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(isDigit(ch)) {
                number = (10 * number) + (ch - '0'); 
            } else if(ch == '+') {
                // number ban chuka hoga
                // result me add karo 
                result = result + (sign * number);
                number = 0;
                sign = 1;
            } else if(ch == '-') {
                // number ban chuka hoga
                // result me add karo 
                result = result + (sign * number);
                number = 0;
                sign = -1;
            } else if(ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else if(ch == ')') {
                result += (number * sign);
                number = 0;
                // bracket ke andhar ka solve hogaya

                int stackSign = stack.pop();
                int stackVal  = stack.pop();
                
                result *= (stackSign);
                result += stackVal;
            }
        }
        result += (sign * number);
        return result;
    }
}