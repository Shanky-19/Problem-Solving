class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        int sum = 0;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(sum,1);
        
        for(int val : nums){
            sum += val;
            
            if(hm.containsKey(sum-goal)){
                ans += hm.get(sum-goal);
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