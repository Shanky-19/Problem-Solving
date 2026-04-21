class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : stones){
            pq.add(val);
        }
        while(pq.size() > 1){
            int lar = pq.remove();
            int slar = pq.remove();
            if(lar != slar){
                pq.add(lar - slar);
            }else{
                pq.add(0);
            }
        }
        return pq.remove();
        
    }
}