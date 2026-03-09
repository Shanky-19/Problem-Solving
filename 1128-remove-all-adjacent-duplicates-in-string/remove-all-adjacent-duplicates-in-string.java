class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(stack.size() == 0) {
                stack.push(ch);
            } else {
                if(stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}