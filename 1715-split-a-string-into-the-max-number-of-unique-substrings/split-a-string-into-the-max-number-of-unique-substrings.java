class Solution {

    int ans = Integer.MIN_VALUE;

    private void solve (int idx, String str, Set<String> set) {
        if(idx == str.length()) {
            ans = Math.max(ans, set.size());
            return;
        }

        for(int i=idx+1;i<=str.length();i++) {
            String substring = str.substring(idx, i);
            if(!set.contains(substring)) {
                set.add(substring);
                // String remainingString = str.substring(i+1);
                solve(i, str, set);
                set.remove(substring);
            }
        }
    }

    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        int idx = 0;
        solve(idx, s, set);
        return ans;
    }
}