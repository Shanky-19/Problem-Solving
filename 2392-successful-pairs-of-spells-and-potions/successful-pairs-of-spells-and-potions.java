class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        List<Integer> ans = new ArrayList<>();
        for(int spell : spells) {
            int idx = helper(potions, success, spell);
            int successfull = n - idx;
            ans.add(successfull);
        }
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private int helper(int[] potions, long success, int spell) {
        int low = 0;
        int high = potions.length-1;
        boolean foundAtleastOne = false;
        while(low <= high) {
            int mid = low + (high-low)/2;

            long product = 1L * spell * potions[mid];
            if(product >= success) {
                high = mid-1;
                foundAtleastOne = true;
            }else {
                low = mid+1;
            }
        }
        if(!foundAtleastOne) {
            return potions.length;
        }
        return low;
    }
}