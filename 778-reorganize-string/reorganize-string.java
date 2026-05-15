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
    
    }

    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.get(ch) > (n+1)/2) { // ceil(n/2) = (n+1)/2 
                return "";
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Character ch : map.keySet()) {
            pq.add(new Pair(ch, map.get(ch)));
        }

        // Build the result.
        char[] ans = new char[n];
        int idx = 0;
        while(pq.size() > 0) {
            Pair first  = pq.remove();
            char ch = first.ch;
            int freq = first.freq;

            while(freq-- > 0) {
                if(idx >= n) {
                    idx = 1;
                }
                ans[idx] = ch;
                idx += 2;
            }
        }
        return String.valueOf(ans);
    }
}