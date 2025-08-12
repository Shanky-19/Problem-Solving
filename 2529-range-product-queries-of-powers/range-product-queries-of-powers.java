class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int M = 1000000007;
        for(int i = 0;i<32;i++) {
            // System.out.println(n & (1 << i));
            if((n & (1 << i)) != 0) { // check if ith bit is enabled or disabled
                powers.add((int)Math.pow(2, i));
            }
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            long product = 1L;
            for(int j=left;j<=right;j++) {
                product = 1L * (product * powers.get(j))%M;
            }
            ans[i] = (int) product;
        }
        return ans;
    }
}