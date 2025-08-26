//Approach - Using Binary Search on Answer
//T.C : O(n * log(max point))
//S.C : O(1)
class Solution {
    private boolean isPossible(long target, int m, int[] points, int n) {
        long moves = 0;
        long advanceGamesToNext = 0;
        long normalMove = 0;

        for (int i = 0; i < n && moves <= m; i++) {
            int gamePoint = points[i];
            long games = (target + gamePoint - 1) / gamePoint; // ceil(target / gamePoint)

            if (advanceGamesToNext >= games) {
                advanceGamesToNext = 0;
                normalMove += 1;
            } else {
                long pointsAlreadyCovered = advanceGamesToNext * gamePoint;
                games = (target - pointsAlreadyCovered + gamePoint - 1) / gamePoint; 
                // ceil((target - pointsAlreadyCovered) / gamePoint);

                moves += (2 * games) - 1;
                advanceGamesToNext = Math.max(games - 1, 0);
                moves += normalMove;
                normalMove = 0;
            }
        }
        return moves <= m;
    }

    public long maxScore(int[] points, int m) {
        int n = points.length;
        long l = 1, r = (long) 1e15;
        long result = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2; // target score
            if (isPossible(mid, m, points, n)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}