class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i = 0;
        int j = 0;
        int countOfT = 0;
        int countOfF = 0;
        int n = answerKey.length();
        int ans = 0;
        while (j < n) {
            char ch = answerKey.charAt(j);
            if(ch == 'T') {
                countOfT++;
            } else {
                countOfF++;
            }

            while (Math.min(countOfT, countOfF) > k) {
                char c = answerKey.charAt(i);
                if(c == 'T') {
                    countOfT--;
                } else {
                    countOfF--;
                }
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}