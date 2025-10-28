class Solution {
    
    class Pair implements Comparable<Pair>{
        String str;
        int freq;
        
        public Pair(String str,int freq){
           this.str = str;
           this.freq = freq;
        }
        
        public int compareTo(Pair p){
            if(p.freq == this.freq){
                return this.str.compareTo(p.str);
            }
            return p.freq - this.freq;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(String str : words){
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Set<String> set = hm.keySet();
        for(String str : set){
            pq.add(new Pair(str,hm.get(str)));
        }
        
        List<String> ans = new ArrayList<>();
        while(k-->0){
            Pair p = pq.remove();
            ans.add(p.str);
        }
        return ans;
    }
}