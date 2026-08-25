class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums) {
            set.add(val);
        }

        int multiple = k;
        while(set.contains(multiple)) {
            multiple += k;
        }
        return multiple;
    }
}