class Solution {

    public void helper(int[] candidates, int target,int idx,
                        List<Integer> al,List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(al));
            return;
        }

        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }

            if(candidates[i]> target){
                break;
            }

            al.add(candidates[i]);
            helper(candidates,target-candidates[i],i+1,al,ans);
            al.remove(al.size()-1);
        }
       
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    // with this we can avoid the condition like [1,7] and [7,1] -> added once
        Arrays.sort(candidates);
        int idx = 0;
        List<Integer> al = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates,target,idx,al,ans);
        return ans;
    }
}