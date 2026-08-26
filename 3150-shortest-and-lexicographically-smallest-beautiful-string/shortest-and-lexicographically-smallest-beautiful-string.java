class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0;
        int j = 0;
        int ones = 0;
        String ans = "";
        while (j < s.length()) {
            if(s.charAt(j) == '1') {
                ones++;
            }

            if(ones == k) {
                while(s.charAt(i) == '0') {
                    i++;
                }
                int len = j-i+1;
                if(ans.length() == 0) {
                    ans = s.substring(i, j+1);
                } else if(ans.length() > len){
                    ans = s.substring(i, j+1);
                } else if(ans.length() == len) {
                    if(s.substring(i,j+1).compareTo(ans) < 0) {
                        ans = s.substring(i, j+1);
                    } 
                }

                while(ones == k) {
                    if(s.charAt(i) != '1') {
                        i++;
                    }
                    i++;
                    ones--;
                }
            }
            j++;
        }
        return ans;
    }
}