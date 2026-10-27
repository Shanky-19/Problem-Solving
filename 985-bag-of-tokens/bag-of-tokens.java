class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int i = 0;
        int j = n-1;
        int score = 0;
        int maxScoreAtAnyState = 0;
        while(i <= j) {
            if(tokens[i] <= power) {
                score++;
                maxScoreAtAnyState = Math.max(maxScoreAtAnyState, score);
                power -= tokens[i];
                i++;
            } else if(score > 0) {
                score--;
                power += tokens[j];
                j--;
            } else {
                // no ops possible
                break;
            }
        }
        return maxScoreAtAnyState;
    }
}