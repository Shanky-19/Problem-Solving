class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int val : answers) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        int ans = 0;
        for(int key : hm.keySet()) {
            int freq = hm.get(key);
            int x = key + 1;
            // System.out.println(Math.ceil(freq/x));
            ans += (x) * (int)Math.ceil((freq*1.0)/x);
        }
        return ans;
    }
}