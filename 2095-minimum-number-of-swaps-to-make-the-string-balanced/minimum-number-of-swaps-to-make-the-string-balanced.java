class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);

            if(ch == ']') {
                if(stack.size() > 0 && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(']');
                }
            } else {
                stack.push('[');
            }
        }

        int unbalanced = stack.size()/2;
        // System.out.println(unbalanced);
        return (int) (Math.ceil((1.0 * unbalanced)/2));
    }
}