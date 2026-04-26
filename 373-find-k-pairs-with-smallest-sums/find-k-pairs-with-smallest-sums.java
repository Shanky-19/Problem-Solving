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
            return this.sum - p.sum;
        }

        public String toString(){
            return (sum + "->" + i + "->" + j);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        minHeap.add(new Pair(nums1[0]+ nums2[0],0,0));
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> visited = new HashSet();
        while (k-- > 0 && minHeap.size() > 0) {
            Pair p = minHeap.remove();
            int sum = p.sum;
            int i = p.i;
            int j = p.j;

            List<Integer> al = new ArrayList<>();
            al.add(nums1[i]);
            al.add(nums2[j]);
            ans.add(al);

            //Push (i, j+1) if possible
            if (j + 1 < m && !visited.contains(i + "->" +(j + 1))) {
                minHeap.add(new Pair(nums1[i]+nums2[j+1], i, j+1));
                visited.add(i + "->" + (j + 1));
            }

            //Push (i+1, j) if possible
            if (i + 1 < n && !visited.contains((i+1)+ "->" +j)) {
                minHeap.add(new Pair(nums1[i+1] + nums2[j], i + 1, j));
                visited.add((i+1) + "->" + j);
            }
        }
        return ans;
    }
}