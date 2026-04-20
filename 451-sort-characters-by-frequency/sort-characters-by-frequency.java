class Solution {

    class Pair implements Comparable<Pair> {
        int freq;
        char ch;

        public Pair (int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }

        public int compareTo(Pair p) {
            return p.freq - this.freq;
        }
    }
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(char key : hm.keySet()) {
            int freq = hm.get(key);
            pq.add(new Pair(freq, key));
        }

        StringBuilder ans = new StringBuilder();

        while(pq.size() > 0) {
            Pair p = pq.remove();
            int freq = p.freq;
            char ch = p.ch;

            while(freq-- > 0) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}