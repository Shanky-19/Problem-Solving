class Solution {

    class Pair implements Comparable<Pair>{ 
        char ch;
        int freq;

        public Pair (char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        public int compareTo(Pair p) {
            return p.freq - this.freq;
        }

        public String toString() {
            return (this.ch + "->" + this.freq);
        }
    }

    public int minimumPushes(String word) {
        Map<Character, Integer> hm = new HashMap<>();
        for(char ch : word.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(char ch : hm.keySet()) {
            pq.add(new Pair(ch, hm.get(ch)));
        }
        // System.out.println(pq);

        int currButton = 2;
        int currPush = 1;
        int pushes = 0;
        while(pq.size() > 0) {
            if(currButton > 9) { // 2..9 -> 8 buttons
                currButton = 2;
                currPush++;
            }
            Pair p = pq.remove();
            pushes += (currPush * p.freq);
            currButton++;
        }
        return pushes;
    }
}