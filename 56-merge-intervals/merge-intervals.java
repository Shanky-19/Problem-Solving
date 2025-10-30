class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> al = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int[] arr = new int[2];
        arr[0] = intervals[0][0];
        arr[1] = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int[] a = intervals[i];
            if(arr[1] >= a[0]){
                // merge the interval;
                arr[0] = Math.min(arr[0],a[0]);
                arr[1] = Math.max(arr[1],a[1]);
            }else{
                al.add(arr);
                arr = new int[2];
                arr[0] = a[0];
                arr[1] = a[1];
            }
        }
        al.add(arr);
        int[][] ans = new int[al.size()][2];
        for(int i=0;i<al.size();i++){
            ans[i][0] = al.get(i)[0];
            ans[i][1] = al.get(i)[1];
        }
        return ans;
    }
}