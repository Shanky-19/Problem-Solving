class Solution {
    public int minAddToMakeValid(String s) {
        int i=0;
        Stack<Character> st = new Stack<>();

        while(i < s.length()){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }else{
                if(st.size() > 0 && st.peek() == '('){
                    st.pop();
                }else{
                    st.push(')');
                }
            }
            i++;
        }
        return st.size();
    }
}