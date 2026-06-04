class Solution {

    private int findWaviness(String str) {
        if(str.length() < 3) {
            return 0;
        }
        int n = str.length();
        int waviness = 0;
        for(int i=1;i<n-1;i++) {
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            char next = str.charAt(i+1);

            if(prev < curr && curr > next) {
                waviness++;
            } else if(prev > curr && next > curr) {
                waviness++;
            }
        }
        return waviness;
    }

    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int i=num1;i<=num2;i++) {
            ans += findWaviness(i + "");
        }
        return ans;
    }
}