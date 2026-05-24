class Solution {
    int mod = 1000000007;
    
    class Pair implements Comparable<Pair>{
        int sum;
        int endIdx;

        public Pair (int sum, int endIdx) {
            this.sum = sum;
            this.endIdx = endIdx;
        }

        public int compareTo(Pair p) {
            return this.sum - p.sum;
        }
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            pq.add(new Pair(nums[i], i));
        }

        int count = 1;
        int ans = 0;
        while (pq.size() > 0) {

            if(count > right) {
                break;
            }

            Pair p = pq.remove();
            int endIdx = p.endIdx;
            int sum = p.sum;

            if(count >= left && count <= right) {
                ans = (ans + sum)%mod;
            }

            // extend subarray and add
            
            if(endIdx + 1 < n) {
                pq.add(new Pair(sum + nums[endIdx+1], endIdx+1));
            }
            count++;
        }

        return (ans%mod);
    }
}