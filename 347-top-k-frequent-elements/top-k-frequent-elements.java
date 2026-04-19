class Solution {

    class Pair implements Comparable<Pair> {
        int freq;
        int val;

        public Pair (int freq, int val) {
            this.freq = freq;
            this.val = val;
        }

        public int compareTo(Pair p) {
            // min Heap
            return this.freq - p.freq;
        }

        public String toString() {
            return (this.val + " -> " + this.freq);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        /*
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int val : nums){
            fmap.put(val, fmap.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Pair> pq 
            = new PriorityQueue<>();
        for(int key : fmap.keySet()) {
            int freq = fmap.get(key);

            pq.add(new Pair(freq, key));

            if(pq.size() > k) {
                pq.remove();
            }
        }
        // System.out.println(pq);
        int[] ans = new int[k];
        int idx = 0;
        while(pq.size() > 0) {
            ans[idx] = pq.remove().val;
            idx++;
        }
        return ans;

        */


        // Approach 2: Variation of Bucket Sort
        /*
        we will store an array where index of that array is the 
        freq count and at that idx we will store an array of value who have that freq
        we will then traverse from end in that array and get k elements and return them
        */
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer>[] freq = new ArrayList[nums.length+1];
        // for(int i=0;i<freq.length;i++){
        //     freq.add(new ArrayList<>());
        // }

        for(int key : hm.keySet()){
            int f = hm.get(key);
            // f is freq of key and it is our index in the freq arr
            if(freq[f] == null){
                freq[f] = new ArrayList<>();
                freq[f].add(key);
            }else{
                freq[f].add(key);
            }
        }   
        
        int j = 0;
        int[] ans = new int[k];
        for(int i=freq.length-1;i>=0;i--){
            if(freq[i] != null){
                for(int val : freq[i]){
                    if(j < k){
                        ans[j] = val;
                        j++;
                    }
                }
            }
        }
        return ans;


    }
}