class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        int i = 0;
        Set<Integer> set = new HashSet<>();
        for(int val : nums) {
            if(set.contains(val)) {
                ans[i] = val;
                i++;
            } else {
                set.add(val);
            }
        }
        return ans;
    }
}