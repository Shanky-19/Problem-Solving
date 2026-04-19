class Solution {

    class Pair implements Comparable<Pair> {
        int freq;
        int val;

        public Pair (int freq, int val) {
            this.freq = freq;
            this.val = val;
        }

        public int compareTo(Pair p) {
            // min Heap
            return this.freq - p.freq;
        }

        public String toString() {
            return (this.val + " -> " + this.freq);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int val : nums){
            fmap.put(val, fmap.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Pair> pq 
            = new PriorityQueue<>();
        for(int key : fmap.keySet()) {
            int freq = fmap.get(key);

            pq.add(new Pair(freq, key));

            if(pq.size() > k) {
                pq.remove();
            }
        }
        // System.out.println(pq);
        int[] ans = new int[k];
        int idx = 0;
        while(pq.size() > 0) {
            ans[idx] = pq.remove().val;
            idx++;
        }
        return ans;
    }
}