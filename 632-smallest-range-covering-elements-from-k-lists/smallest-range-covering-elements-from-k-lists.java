class Solution {
    class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val,int idx){
            this.val = val;
            this.idx = idx;
        }
        public int compareTo(Pair p){
            return this.val - p.val;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        ArrayList<Pair> al = new ArrayList<>();
        int k= nums.size();
        for(int i=0;i<nums.size();i++){
            List<Integer> a = nums.get(i);
            for(int val : a){
                Pair p = new Pair(val,i);
                al.add(p);
            }
        }

        Collections.sort(al);
        Map<Integer,Integer> hm = new HashMap<>();
        int i = 0;
        int j = 0;
        int left = 0;
        int right = 0;
        int range = Integer.MAX_VALUE;
        while(j < al.size()){
            Pair p = al.get(j);
            hm.put(p.idx,hm.getOrDefault(p.idx,0)+1);
            
            if(hm.size() == k){
                while(i < j){
                    Pair p2 = al.get(i);
                    if(hm.get(p2.idx) == 1){
                        break;
                    }else{
                        hm.put(p2.idx,hm.get(p2.idx)-1);
                        i++;
                    }
                }
                if(range > al.get(j).val-al.get(i).val){
                    left = al.get(i).val;
                    right = al.get(j).val;
                    range = right-left;
                }
            }
            j++;
        }
        int[] ans= new int[2];
        ans[0] = left;
        ans[1] = right;
        return ans;
    }
}