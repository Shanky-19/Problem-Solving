class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        StringBuilder firstRow = new StringBuilder();
        for(int i=0;i<n;i++) {
            firstRow.append(".");
        }
        StringBuilder otherRows = new StringBuilder();
        for(int i=0;i<n-1;i++) {
            otherRows.append("#");
        }
        otherRows.append(".");

        ans[0] = firstRow.toString();
        for(int i=1;i<m;i++) {
            ans[i] = otherRows.toString();
        }
        return ans;
    }
}