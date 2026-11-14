
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;

        int i = 0;

        while (i < n) {
            int j = i;
            int sum = 0;

            while (j < n && j - i + 1 <= r) {
                sum += nums.get(j);

                int size = j - i + 1;

                if (size >= l && sum > 0) {
                    minSum = Math.min(minSum, sum);
                }

                j++;
            }

            i++;
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
