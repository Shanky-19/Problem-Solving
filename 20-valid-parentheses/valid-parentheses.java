class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else{
                if(ch == ')'){
                    if(st.size() == 0 || st.pop() != '('){
                        return false;
                    }
                }else if(ch == ']'){
                    if(st.size() == 0 || st.pop() != '['){
                        return false;
                    }
                }else{
                    if(st.size() == 0 ||st.pop() != '{'){
                        return false;
                    }
                }
            }
        }
        return st.size()==0;
    }
}