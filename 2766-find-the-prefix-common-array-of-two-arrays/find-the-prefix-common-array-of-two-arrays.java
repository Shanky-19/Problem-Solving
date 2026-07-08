class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            set.add(A[i]);
            set.add(B[i]);

            // set size if no common prefix
            // will be 2*(i+1) as 2*(i+1) elements and
            // will be different

            // so common prefi = 2*(i+1) - set.size();
            // also numbers are not repeated otherwise
            // we would need hashmap to track freq
            ans[i] = 2*(i+1) - set.size();
        }
        return ans;
    }
}