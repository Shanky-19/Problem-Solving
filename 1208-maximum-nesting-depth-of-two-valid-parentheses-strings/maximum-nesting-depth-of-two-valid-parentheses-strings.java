class Solution {
    public int[] maxDepthAfterSplit(String str) {
        int n = str.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (i ^ str.charAt(i)) & 1;
        }
        return ans;
    }
}