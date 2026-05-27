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
            return "ch:" + ch + " ,freq:" +freq ;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        if(a > 0) {
            pq.add(new Pair('a', a));
        }
        if(b > 0) {
            pq.add(new Pair('b', b));
        }
        if(c > 0) {
            pq.add(new Pair('c', c));
        }

        char prev = 'z';
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            Pair p = pq.remove();
            char ch = p.ch;
            int freq = p.freq;

            if(prev == ch && count == 2) {
                if(pq.size() > 0) {
                    Pair pair = pq.remove();
                    char newCh = pair.ch;
                    int newFreq = pair.freq;
                    sb.append(newCh);
                    prev = newCh;
                    count = 1;

                    newFreq--;
                    if(newFreq > 0) {
                        pq.add(new Pair(newCh, newFreq));
                    }
                    pq.add(p);
                } else {
                    return sb.toString();
                }
            } else if(prev == ch) {
                prev = ch;
                count++;
                sb.append(ch);

                // freq--;
                p.freq--;
                if(p.freq > 0) {
                    pq.add(p);
                }
            } else {
                prev = ch;
                count = 1;
                sb.append(ch);
                p.freq--;
                if(p.freq > 0) {
                    pq.add(p);
                }
            }

        }
        return sb.toString();
    }
}