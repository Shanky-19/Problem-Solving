class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(ch == ')') {
                StringBuilder sb = new StringBuilder();
                while (st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
                for(char c : sb.toString().toCharArray()) {
                    st.push(c);
                }
            } else {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}