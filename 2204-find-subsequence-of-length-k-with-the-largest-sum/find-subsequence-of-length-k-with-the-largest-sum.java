class Solution {

    class Pair implements Comparable<Pair>{
        int idx;
        int val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        public int compareTo(Pair p) {
            return this.val - p.val;
        }
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            Pair p = new Pair(i, nums[i]);
            minHeap.add(p);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // for maintaining order as it is subsequence
        List<Pair> list = new ArrayList<>(minHeap);
        Collections.sort(list, (a, b) -> {
            return a.idx - b.idx;
        });

        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            ans[i] = list.get(i).val;
        }
        return ans;

    }
}