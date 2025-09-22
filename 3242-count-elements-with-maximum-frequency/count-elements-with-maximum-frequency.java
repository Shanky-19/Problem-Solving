class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int val : nums) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }

        int maxFreq = 0;
        for (int key : hm.keySet()) {
            if(hm.get(key) > maxFreq) {
                maxFreq = hm.get(key);
            }
        }

        int ans = 0;
        for(int val : nums) {
            if(maxFreq == hm.get(val)) {
                ans++;
            }
        }
        return ans;
    }
}