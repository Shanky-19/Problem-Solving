class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--) {
            while (stack.size() > 0 
                && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if(stack.size() == 0) {
                ans[i] = 0;
            } else {
                ans[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return ans;
    }
}