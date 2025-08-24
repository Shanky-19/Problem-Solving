class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int low = 1;
        int high = 100000;
        int ans = -1;
        while (low <= high) {
            // maxProducts
            int mid = low + (high - low)/2;
            if(isPossible(quantities, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
        
    }

    private boolean isPossible(int[] quantities, int n, int maxProducts) {
        int count = 0;
        for(int val : quantities) {
            count += (int)Math.ceil((1.0 * val)/maxProducts);
        }
        // store can also have 0 products
        return (count <= n);
    }
}