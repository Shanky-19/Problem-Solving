class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = 
            new PriorityQueue(Collections.reverseOrder());
        for(int val : piles){
            pq.add(val);
        }

        while(k > 0){
            int val = pq.remove();
            val -= val/2;
            pq.add(val);
            k--;
        }

        int ans = 0;
        while(pq.size() > 0){
            ans += pq.remove();
        }
        return ans;
        
    }
}