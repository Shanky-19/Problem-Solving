class Solution {
 
    private boolean isPalindrome(String str) {
        int n = str.length();
        int i = 0;
        int j = n-1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private void solve(int idx, String str, List<String> al, 
                        List<List<String>> ans) {
        if(idx == str.length()) {
            ans.add(new ArrayList<>(al));
            return;
        }

        // Set<String> set = new HashSet<>();

        for(int i= idx;i<str.length();i++) {
            String substr = str.substring(idx, i+1);
            // if(set.contains(substr)) {
            //     continue;
            // }

            // System.out.println(substr);

            if(isPalindrome(substr)) {
                // System.out.println("hi");
                // set.add(substr);
                al.add(substr);
                solve(i+1, str, al, ans);
                al.remove(al.size()-1);
            }
            
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> al = new ArrayList<>();
        int idx = 0;
        solve(idx, s, al, ans);
        return ans;
    }
}