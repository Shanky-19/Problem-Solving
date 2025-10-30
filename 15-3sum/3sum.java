class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int val1 = nums[i];
            int x = i+1;
            int y = n-1;

            while(x < y){
                int sum = val1 + nums[x] + nums[y];
                if(sum == 0){
                    List<Integer> al = new ArrayList<>();
                    al.add(val1);
                    al.add(nums[x]);
                    al.add(nums[y]);

                    set.add(al);
                    x++;
                    y--;
                }else if(sum > 0){
                    y--;
                }else{
                    x++;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> al : set){
            ans.add(al);
        }
        return ans;
    }
}