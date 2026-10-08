class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        int[] xor = new int[n];
        xor[0] = arr[0];
        for(int i=1;i<n;i++) {
            xor[i] = xor[i-1] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = xor[r];
            if(l > 0) {
                ans[i] = ans[i] ^ xor[l-1];
            }
        }
        return ans;
    }
}