class Solution {
    public int maxDistance(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;
       
        // observation 1:
        // maximum Manhattan distance will be totla number of step => s.length()

        // observation 2:
        // Manhattan distance at any point of time => |E-W| + |N-S| (freq of each dir)

        int maxManhattanDistance = 0;
        int numberOfStepsTaken = 0;
        int E = 0;
        int W = 0;
        int N = 0;
        int S = 0;
        for(int i=0;i<n;i++) {
            char ch = str[i];

            if(ch == 'N') {
                N++;
            }else if(ch == 'S') {
                S++;
            }else if(ch == 'E') {
                E++;
            }else {
                W++;
            }
            numberOfStepsTaken += 1;
            int Manhattan = Math.abs(E-W) + Math.abs(N-S);
            int wasted = numberOfStepsTaken - Manhattan;
            int extra = 0;
            if(wasted != 0 && k > 0) {
                extra = Math.min(2*k, wasted);
            }
            Manhattan += extra;
            maxManhattanDistance = Math.max(maxManhattanDistance, Manhattan);
        }
        return maxManhattanDistance;

    }
}
