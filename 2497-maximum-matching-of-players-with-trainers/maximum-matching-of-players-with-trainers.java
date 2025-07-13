class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int n = players.length;
        int m = trainers.length;
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i < n && j < m) {
            if(players[i] <= trainers[j]) {
                //match;
                ans++;
                i++;
                j++;
            }else {
                j++;
            }
        }
        return ans;
    }
}