class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] leftClosestR = new int[n];
        int[] rightClosestL = new int[n];

        int currPush = -1;
        for(int i=0;i<n;i++) {
            char ch = dominoes.charAt(i);
            if(ch == 'R') {
                currPush = i;
            } else if (ch == 'L'){
                currPush = -1; 
            }
            leftClosestR[i] = currPush;
        }

        currPush = -1;
        for(int i=n-1;i>=0;i--) {
            char ch = dominoes.charAt(i);
            if(ch == 'L') {
                currPush = i;
            } else if (ch == 'R'){
                currPush = -1; 
            }
            rightClosestL[i] = currPush;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            
            if(leftClosestR[i] == -1 && rightClosestL[i] == -1) {
                sb.append('.');
            } else if(leftClosestR[i] == -1) {
                sb.append('L');
            } else if(rightClosestL[i] == -1) {
                sb.append('R');
            } else {
                int distToLeftClosestR = Math.abs(i - leftClosestR[i]);
                int distToRightClosestL = Math.abs(i - rightClosestL[i]);
                if(distToLeftClosestR == distToRightClosestL) {
                    sb.append('.');
                } else if (distToLeftClosestR < distToRightClosestL) {
                    sb.append('R');
                } else {
                    sb.append('L');
                }
            }
        }
        return sb.toString();
    }
}

