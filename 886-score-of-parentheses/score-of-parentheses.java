class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(-1);
            }else{
                int sum = 0;
                while(st.peek() != -1){
                    sum += st.pop();
                }
                if(sum == 0){
                    sum = 1;
                }else{
                    sum *= 2;
                }
                st.pop(); // -1 -> here is '('
                st.push(sum);
            }
        }
        int ans = 0;
        while(st.size() > 0){
            ans += st.pop();
        }
        return ans;
    }
}