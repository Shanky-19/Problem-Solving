class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int score = 0;

        String maxStr = (x > y) ? "ab" : "ba";
        String minStr;
        if(maxStr.equals("ab")) { 
            minStr = "ba";
        }
        else {
            minStr = "ab";
        }

        // First Pass
        String tempFirst = removeSubstringConstantSpace(s, maxStr);
        int removedPairsCount = (n - tempFirst.length()) / 2;
        score += removedPairsCount * Math.max(x, y);

        // Second Pass
        String tempSecond = removeSubstringConstantSpace(tempFirst, minStr);
        removedPairsCount = (tempFirst.length() - tempSecond.length()) / 2;
        score += removedPairsCount * Math.min(x, y);

        return score;
    }



    private String removeSubstringConstantSpace(String inputString, 
                                                String matchStr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        for (int j = 0; j < inputString.length(); j++) {
            sb.append(inputString.charAt(j));
            i++;

            if (i > 1 && 
                sb.charAt(i - 2) == matchStr.charAt(0) 
                && sb.charAt(i - 1) == matchStr.charAt(1)) {
                
                sb.delete(i - 2, i);
                i -= 2;

            }
        }

        return sb.toString();
    }
}