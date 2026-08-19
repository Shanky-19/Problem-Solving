class Solution {

    public void backtrack(int idx,int[] nums,List<List<Integer>> ans,List<Integer> al,int n){
        if(idx == n){
            if(al.size() == n){
                ans.add(new ArrayList<>(al));
            }
            return;
        }

        for(int i=0;i<n;i++){
            if(nums[i] != -11){
                al.add(nums[i]);
                int temp = nums[i];
                nums[i] = -11;
                backtrack(idx+1,nums,ans,al,n);
                nums[i] = temp;
                al.remove(al.size()-1);
            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        int idx = 0;
        int n = nums.length;
        backtrack(idx,nums,ans,al,n);
        return ans;
    }
}