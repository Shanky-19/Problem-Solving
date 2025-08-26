class Solution {
    public int maximumCandies(int[] candies, long k) {
        long low = 1;
        long high = (long)1e12;
        long ans = 0;

        while(low <= high) {
            long mid = low + (high - low)/2;

            long children = calculate(mid, candies);

            if(children < k) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private long calculate(long candiesPile, int[] candies) {
        long childrens = 0;
        for(int c : candies) {
            childrens += c/candiesPile;
        }
        return childrens;
    }
}