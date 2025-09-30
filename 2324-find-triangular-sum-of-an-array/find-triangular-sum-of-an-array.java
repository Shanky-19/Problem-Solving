class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++) {
            temp.add(nums[i]);
        }

        while (temp.size() > 1) {
            int size = temp.size();
            List<Integer> t = new ArrayList<>();
            for(int i=1;i<temp.size();i++) {
                t.add((temp.get(i) + temp.get(i-1))%10);
            }
            temp = t;
        }

        System.out.println(temp);
        return temp.get(0);
    }
}