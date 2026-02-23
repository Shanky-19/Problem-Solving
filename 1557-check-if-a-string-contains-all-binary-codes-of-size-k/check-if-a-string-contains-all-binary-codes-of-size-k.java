class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        for(int i=0;i<=n-k;i++) {
            String subString = s.substring(i, i+k);
            set.add(subString);
        }

        if(set.size() == (int) (Math.pow(2, k))) {
            return true;
        }
        return false;
    }
}