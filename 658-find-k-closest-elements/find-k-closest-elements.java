class Solution {

    class Pair implements Comparable<Pair>{
        int diff;
        int val;

        public Pair (int diff, int val) {
            this.diff = diff;
            this.val = val;
        }

        public int compareTo(Pair p) {
            if(this.diff == p.diff) {
                return this.val - p.val;
            }
            return this.diff - p.diff;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            int diff = Math.abs(x - arr[i]);
            pq.add(new Pair(diff, arr[i]));

            if(pq.size() > k) {
                pq.remove();
            }
        }

        while(pq.size() > 0) {
            ans.add(pq.remove().val);
        }

        Collections.sort(ans);
        return ans;
    }
}