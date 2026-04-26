class Solution {
    class Pair implements Comparable<Pair>{
        int val1;
        int val2;

        public Pair(int val1,int val2){
            this.val1 = val1;
            this.val2 = val2;
        }

        public int compareTo(Pair p){
            return p.val2 - this.val2;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        Pair[] arr = new Pair[nums1.length];
        for(int i=0;i<nums1.length;i++){
            Pair p = new Pair(nums1[i],nums2[i]);
            arr[i] = p;
        }

        Arrays.sort(arr);
        
        int idx = k-1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for(int i=0;i<=idx;i++){
            pq.add(arr[i].val1);
            sum += arr[i].val1;
        }
        int min = arr[k-1].val2;
        long ans = sum * min;

        for(int i=k;i<arr.length;i++){
            int minVal = arr[i].val2;
            // removing the lowest value so sum is maximized
            int rmv = pq.remove();

             // if our min is arr[i].val2 then sum must contain this
            pq.add(arr[i].val1);

            sum -= rmv;
            sum += arr[i].val1;

            long tempAns = sum * minVal;
            ans = Math.max(ans,tempAns);
        }
        return ans;
    }
}