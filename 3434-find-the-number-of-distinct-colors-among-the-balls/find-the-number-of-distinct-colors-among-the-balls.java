class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        // ball and its color
        Map<Integer, Integer> balls = new HashMap<>();

        // color and count of balls having this color
        Map<Integer, Integer> colors = new HashMap<>();

        int currDistinctColorsCount = 0;
        for(int i=0;i<n;i++) {
            int[] q = queries[i];
            int ball = q[0];
            int color = q[1];
            
            // remove ball's existing color
            if(balls.containsKey(ball)) {
                int currBallColor = balls.get(ball);
                int count = colors.get(currBallColor) - 1;
                if(count == 0) {
                    colors.remove(currBallColor);
                    currDistinctColorsCount--;
                } else {
                    colors.put(currBallColor, count);
                }
            } 
            // update the ball with new color
            balls.put(ball, color);
            int count = colors.getOrDefault(color, 0) + 1;
            colors.put(color, count);
            if(count == 1) {
                currDistinctColorsCount++;
            }
            ans[i] = currDistinctColorsCount;
        }
        return ans;
    }
}