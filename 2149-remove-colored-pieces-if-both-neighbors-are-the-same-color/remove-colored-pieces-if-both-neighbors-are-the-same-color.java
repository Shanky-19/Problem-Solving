class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        char prev = colors.charAt(0);
        int alice = 0;
        int bob = 0;
        for(int i=1;i<n-1;i++) {
            char curr = colors.charAt(i);
            char next = colors.charAt(i+1);
            if(prev == curr && curr == next) {
                if(curr == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            } else {
                prev = curr;
            }
        }

        return (alice > bob);

    }
}