class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int m = baskets.length;
        int ans = n;
        for(int i=0;i<n;i++) {
            int fruit = fruits[i];
            for(int j=0;j<m;j++) {
                int basket = baskets[j];
                if(fruit <= basket) {
                    // System.out.println(fruit + " " + basket);
                    baskets[j] = -1;
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}