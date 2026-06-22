class Solution {
    class Pair {
        int win;
        int loss;
        public Pair (int win, int loss) {
            this.win = win;
            this.loss = loss;
        }
    }
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        HashMap<Integer, Pair> hm = new HashMap<>();
        for(int[] match : matches) {
            int winner = match[0];
            int loser  = match[1];

            if(!hm.containsKey(winner)) {
                hm.put(winner, new Pair(1, 0));
            } else {
                Pair p = hm.get(winner);
                p.win += 1;
                hm.put(winner, p);
            }

            if(!hm.containsKey(loser)) {
                hm.put(loser, new Pair(0, 1));
            } else {
                Pair p = hm.get(loser);
                p.loss += 1;
                hm.put(loser, p);
            }
            
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> allWins = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();
        for(int key : hm.keySet()) {
            Pair p = hm.get(key);
            if(p.loss == 0) {
                allWins.add(key);
            } else if(p.loss == 1){
                oneLose.add(key);
            }
        }
        Collections.sort(allWins);
        Collections.sort(oneLose);
        ans.add(allWins);
        ans.add(oneLose);
        return ans;
    }
}