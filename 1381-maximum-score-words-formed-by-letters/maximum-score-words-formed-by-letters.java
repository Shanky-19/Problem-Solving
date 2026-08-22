class Solution {
    int ans = Integer.MIN_VALUE;

    private boolean isPossibleToPick (String word, int[] freqMap) {
        int[] tempFreqMap = new int[freqMap.length];
        for(int i=0;i<freqMap.length;i++) {
            tempFreqMap[i] = freqMap[i];
        }
        
        for(char ch : word.toCharArray()){
            if(tempFreqMap[ch - 'a'] <= 0) {
                return false;
            } else {
                tempFreqMap[ch - 'a']--;
            }
        }
        return true;
    }

    private int calculateScoreAndUpdateFreq(String word, int[] freqMap, int[] score) {
        int ans = 0;
        for(char ch : word.toCharArray()) {
            freqMap[ch-'a']--;
            ans += score[ch-'a'];
        }
        return ans;
    }

    private void reUpdateTheFreq(String word, int[] freqMap) {
        for(char ch : word.toCharArray()) {
            freqMap[ch-'a']++;
        }
    }


    private void solve(int idx, String[] words, int[] freqMap,
                        int[] score, int scoreSoFar) {

        if(idx == words.length) {
            ans = Math.max(ans, scoreSoFar);
            return;
        }

        // pick

        boolean isPossibleToPick = isPossibleToPick(words[idx], freqMap);
        if(isPossibleToPick) {
            int scoreIfPicked = calculateScoreAndUpdateFreq(words[idx], freqMap, score);
            scoreSoFar += scoreIfPicked;
            solve(idx+1, words, freqMap, score, scoreSoFar);
            scoreSoFar -= scoreIfPicked;
            reUpdateTheFreq(words[idx], freqMap);
        }
        
        //not pick
        solve(idx+1, words, freqMap, score, scoreSoFar);

    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freqMap = new int[26];
        for(char ch : letters) {
            freqMap[ch-'a']++;
        }

        int idx = 0;
        int scoreSoFar = 0;
        solve(idx, words, freqMap, score, scoreSoFar);

        return ans;

    }
}