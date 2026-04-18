//Approach-2 (Using Stack)
//T.C : O(m*n)
//S.C : O(m)
class Solution {
    private boolean check(Stack<Character> st, String part, int n) {
        Stack<Character> tempSt = new Stack<>();
        tempSt.addAll(st);

        for (int idx = n - 1; idx >= 0; idx--) {
            if (tempSt.peek() != part.charAt(idx)) {
                return false;
            }

            tempSt.pop();
        }

        return true;
    }

    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int m = s.length();
        int n = part.length();

        for (int i = 0; i < m; i++) {
            st.push(s.charAt(i));

            if (st.size() >= n && check(st, part, n)) {
                for (int j = 0; j < n; j++) {
                    st.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.reverse().toString();
    }
}