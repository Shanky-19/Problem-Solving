class Solution {
    public int specialTriplets(int[] nums) {
        final int max = 1000000007;
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int num : nums) {
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
        }
        long ans = 0;
        for (int num : nums) {
            rightMap.put(num, rightMap.get(num) - 1);
            ans += 1L * 
                leftMap.getOrDefault(num * 2, 0) 
                * rightMap.getOrDefault(num * 2, 0);
            ans %= max;
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
        }
        return (int) ans;
    }
}