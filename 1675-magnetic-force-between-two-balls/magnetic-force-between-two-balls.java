class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = position[n-1]-1;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isPossible(mid,position, m, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;

    }

    private boolean isPossible(int force, int[] position, int m, int n) {
        int lastPos = position[0];
        m -= 1;
        for(int i=1;i<n;i++) {
            int currPos = position[i];
            if(currPos-lastPos >= force) {
                m--;
                lastPos = currPos;
            }
            if(m == 0) {
                return true;
            }
        }
        return false;
    }

}