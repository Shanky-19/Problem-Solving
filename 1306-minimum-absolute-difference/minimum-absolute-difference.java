class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i=0;i<n-1;i++) {
            int diff = arr[i+1]-arr[i];
            if(diff < minDiff) {
                minDiff = diff;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<n-1;i++) {
            int diff = arr[i+1]-arr[i];
            if(diff == minDiff) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                ans.add(temp);
            }
        }
        return ans;
    }
}