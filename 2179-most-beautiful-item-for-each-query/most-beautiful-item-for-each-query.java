class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b) -> {
            return a[0]-b[0];
        });

        int n = items.length;
        int m = items[0].length;

        // prefix arr to store maxBeauty till idx
        for(int i=1;i<n;i++) {
            int currB = items[i][1];
            int prevB = items[i-1][1];
            items[i][1] = Math.max(currB, prevB);
        }
        int l = queries.length;
        int[] ans = new int[l];
        for(int i=0;i<l;i++) {
            int q = queries[i];
            int maxBeauty = findMaxBeauty(q, items);
            ans[i] = maxBeauty;
        }
        return ans;
    }

    private int findMaxBeauty(int currPrice, int[][] items) {
        int low = 0;
        int high = items.length-1;
        int ans = 0;
        while(low <= high) {
            int mid = low + (high-low)/2;

            if(items[mid][0] <= currPrice) {
                ans = items[mid][1];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}