class Solution {

    public void helper(int[] nums,int idx,List<Integer> al,
                            Set<List<Integer>> set){

        if(idx == nums.length){
            set.add(new ArrayList<>(al));
            return;
        }
        
        // pick
        al.add(nums[idx]);
        helper(nums,idx+1,al,set);
        al.remove(al.size()-1);

        //not pick
        helper(nums,idx+1,al,set);


    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        int idx = 0;
        helper(nums,idx,al,set);
        for(List<Integer> list : set){
            ans.add(list);
        }
        return ans;
    }
}