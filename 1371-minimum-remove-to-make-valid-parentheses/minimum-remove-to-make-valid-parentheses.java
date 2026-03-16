class Solution {
    public String minRemoveToMakeValid(String s) {
        // we have to remove invalid parenthesis
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        Set<Integer> removeIdx = new HashSet<>();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(i);
            } else if(ch == ')') {
                if(st.size() == 0) {
                    removeIdx.add(i);
                } else {
                    st.pop();
                }
            }
        }

        while(st.size() > 0) {
            removeIdx.add(st.peek());
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            if(!removeIdx.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}