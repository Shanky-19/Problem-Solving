class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int val : arr) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        Set<Integer> values = new HashSet<>();
        for(int val : hm.values()) {
            if(values.contains(val)) {
                return false;
            } else {
                values.add(val);
            }
        }
        return true;
    }
}