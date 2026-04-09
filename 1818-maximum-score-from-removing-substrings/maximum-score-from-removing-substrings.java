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

    private String removeSubstring(String s, String matchStr) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && ch == matchStr.charAt(1) 
                && stack.peek() == matchStr.charAt(0)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder remainStr = new StringBuilder();
        while (!stack.isEmpty()) {
            remainStr.append(stack.pop());
        }
        return remainStr.reverse().toString();
    }

    private String removeSubstringConstantSpace(String inputString, 
                                                String matchStr) {
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for (int i = 0; i < inputString.length(); i++) {
            sb.append(inputString.charAt(i));
            j++;

            if (j > 1 && 
                sb.charAt(j - 2) == matchStr.charAt(0) 
                && sb.charAt(j - 1) == matchStr.charAt(1)) {
                
                sb.delete(j - 2, j);
                j -= 2;

            }
        }

        return sb.toString();
    }
}