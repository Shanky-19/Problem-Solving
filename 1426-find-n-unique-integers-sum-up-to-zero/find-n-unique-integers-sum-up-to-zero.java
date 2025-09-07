class Solution {
    public int[] sumZero(int n) {
        List<Integer> list = new ArrayList<>();
        int x = n/2;
        while(x> 0) {
            list.add(x);
            list.add(-x);
            x--;
        }
        if(n%2 != 0) {
            list.add(0);
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}