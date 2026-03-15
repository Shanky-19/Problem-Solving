class Solution {
    public List<String> buildArray(int[] target, int n) {
        int val = 1;
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        List<String> ans = new ArrayList<>();
        while(idx < target.length) {
            
            while (target[idx] > val) {
                ans.add("Push");
                ans.add("Pop");
                val++;
            }

            if(target[idx] == val) {
                st.push(val);
                idx++;
                ans.add("Push");
                val++;
            } 

        }
        return ans;
    }
}