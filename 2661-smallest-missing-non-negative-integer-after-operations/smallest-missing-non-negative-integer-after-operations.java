class Solution {

    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            int mod = val % value;
            if(mod < 0){
                mod += value;
            }
            map.put(mod,map.getOrDefault(mod,0)+1);
        }
            
        int i=0;
        while(true){
            int mod = i%value;
            if(map.containsKey(mod)){
                map.put(mod,map.get(mod)-1);
                if(map.get(mod) == 0){
                    map.remove(mod);
                }
                i++;
            }else{
                return i;
            }
        }
    }

    
}