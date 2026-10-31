class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        
        int i = 0;
        while(i < n && coins >= costs[i]) {
            coins -= costs[i];
            i++;
        }
        return i;
    }
}