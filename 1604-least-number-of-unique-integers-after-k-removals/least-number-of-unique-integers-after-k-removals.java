

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int val : arr) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        
        List<Integer> al = new ArrayList<>();
        int count = 0;
        for (int val : hm.values()) {
            al.add(val);
        }
        
        Collections.sort(al);
        for (int i = 0; i < al.size(); i++) {
            if (k > al.get(i)) {
                k -= al.get(i);
                al.set(i, 0);
            } else {
                al.set(i, al.get(i) - k);
                k = 0;
            }
            if (al.get(i) != 0) {
                count++;
            }
        }
        return count;
    }
}
