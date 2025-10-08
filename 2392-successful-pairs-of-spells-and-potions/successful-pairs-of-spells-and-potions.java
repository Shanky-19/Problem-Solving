class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] ans = new int[spells.length];
        for(int i=0;i<spells.length;i++) {
            int spell = spells[i];
            int idx = helper(potions, success, spell);
            int successfull = n - idx;
            ans[i] = successfull;
        }
        return ans;
    }

    private int helper(int[] potions, long success, int spell) {
        int low = 0;
        int high = potions.length-1;
        int ans = potions.length;
        while(low <= high) {
            int mid = low + (high-low)/2;

            long product = (long) spell * potions[mid];
            if(product >= success) {
                high = mid-1;
                ans = mid;
            }else {
                low = mid+1;
            }
        }
        return ans;
    }
}