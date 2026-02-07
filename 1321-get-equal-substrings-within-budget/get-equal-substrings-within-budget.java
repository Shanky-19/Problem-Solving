class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for(int i=0;i<n;i++) {
            diff[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }

        // now we need max length subarray of diff
        // whose sum of elements is less than equal to maxCost
        int i=0;
        int j=0;
        int ans = 0;
        int sum = 0;
        while (j < n) {
            sum += diff[j];

            while(sum > maxCost) {
                sum -= diff[i];
                i++;
            }

            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;

    }
}