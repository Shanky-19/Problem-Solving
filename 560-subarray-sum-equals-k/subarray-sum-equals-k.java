class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(sum,1);
        
        for(int val : nums){
            sum += val;
            
            if(hm.containsKey(sum-k)){
                ans += hm.get(sum-k);
            }
            
            if(hm.containsKey(sum)){
                hm.put(sum,hm.get(sum)+1);
            }else{
                hm.put(sum,1);
            }
        }
        return ans;
        
    }
}