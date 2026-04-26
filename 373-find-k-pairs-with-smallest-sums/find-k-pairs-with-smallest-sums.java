class Solution {

    class Pair implements Comparable<Pair> {
        int sum;
        int i;
        int j;

        public Pair (int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }

        public int compareTo(Pair p) {
            return p.sum - this.sum;
        }

        public String toString() {
            return (sum + "->" + i + "->" + j);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = nums1.length;
        int m = nums2.length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                int sum = nums1[i] + nums2[j];

                if(pq.size() < k) {
                    pq.add(new Pair (sum, i, j));
                } else if(sum < pq.peek().sum) {
                    pq.remove();
                    pq.add(new Pair(sum, i, j));
                } else {
                    break;
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while(pq.size() > 0) {
            List<Integer> al = new ArrayList<>();
            Pair p = pq.remove();
            al.add(nums1[p.i]);
            al.add(nums2[p.j]);
            ans.add(al);
        }
        return ans;
    }
}