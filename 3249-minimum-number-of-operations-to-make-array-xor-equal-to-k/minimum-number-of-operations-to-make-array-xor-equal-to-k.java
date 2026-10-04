class Solution {
    public int minOperations(int[] nums, int k) {
        int operations = 0;
        for(int i=0;i<32;i++) {
            int expected = k & (1<<i);

            int actual = 0;
            for(int num : nums) {
                int bit = num & (1<<i);
                actual = actual ^ bit;
            }

            if(actual != expected) {
                operations++;
            }
        }
        return operations;
    }
}