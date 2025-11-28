class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int count = 0;
        // parse 1 -> searching for T
        while(j < n){
            if(answerKey.charAt(j) == 'F'){
                if(count < k){
                    count++;
                }else{
                    while(answerKey.charAt(i) != 'F'){
                        i++;
                    }
                    i++;
                    // count--;
                }
            }
            
            maxLength = Math.max(maxLength,j-i+1);
            j++;
        }
        i = 0;
        j = 0;
        count = 0;
        // parse 2 -> searching for F
        while(j < n){
            
            if(answerKey.charAt(j) == 'T'){
                if(count < k){
                    count++;
                }else{
                    while(answerKey.charAt(i) != 'T'){
                        i++;
                    }
                    i++;
                }
            }
            
            maxLength = Math.max(maxLength,j-i+1);
            j++;
        }
        
        return maxLength;
    }
}