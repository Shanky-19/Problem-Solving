class Solution {

    // Helper method to find the lower bound index
    private int lowerBound(List<Integer> arr, int target) {
        int left = 0, right = arr.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Helper method to find the upper bound index
    private int upperBound(List<Integer> arr, int target) {
        int left = 0, right = arr.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        List<Integer> prefixSum = new ArrayList<>();
        List<Integer> positions = new ArrayList<>();

        for(int i=0;i<n;i++) {
            positions.add(fruits[i][0]);

            if(i > 0) {
                prefixSum.add(fruits[i][1] + prefixSum.get(i-1));
            } else {
                prefixSum.add(fruits[i][1]);
            }
        }

        int maxFruits = 0;
        for(int d=0; d<=k/2; d++) {

            // case-1 : left side d distance chalo
            int i = startPos - d;
            int j = startPos + k - 2*d;
            int left = lowerBound(positions, i);
            int right = upperBound(positions, j)-1;
            
            if (left <= right) {
                int result = prefixSum.get(right) - (left > 0 ? prefixSum.get(left - 1) : 0);
                maxFruits = Math.max(maxFruits, result);                
            }

            // case-2 : right side d distance chalo
            i = startPos - (k-2*d);
            j = startPos + d;
            left = lowerBound(positions, i);
            right = upperBound(positions, j)-1;
            
            if (left <= right) {
                int result = prefixSum.get(right) - (left > 0 ? prefixSum.get(left - 1) : 0);
                maxFruits = Math.max(maxFruits, result);                
            }
            
        }
        return maxFruits;
    }
}