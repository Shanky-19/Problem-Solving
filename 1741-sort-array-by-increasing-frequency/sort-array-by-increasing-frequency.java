class Solution {

    class Pair implements Comparable<Pair> {
        int freq;
        int val;

        public Pair (int freq, int val) {
            this.freq = freq;
            this.val = val;
        }

        public int compareTo(Pair p) {
            if(this.freq == p.freq) {
                return p.val - this.val;
            }
            return this.freq - p.freq;
        }
    }
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int val : nums) {
            hm.put(val, hm.getOrDefault(val,0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key : hm.keySet()) {
            int freq = hm.get(key);
            pq.add(new Pair(freq, key));
        }

        int[] ans = new int[nums.length];
        int idx = 0;
        while(pq.size() > 0) {
            Pair p = pq.remove();
            int freq = p.freq;
            int val = p.val;

            while(freq > 0) {
                ans[idx] = val;
                idx++;
                freq--;
            }
        }
        return ans;
    }
}