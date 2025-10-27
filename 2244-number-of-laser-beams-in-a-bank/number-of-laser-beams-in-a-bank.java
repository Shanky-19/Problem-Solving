class Solution {
    class Pair {
        int row;
        int ones;

        public Pair (int row, int ones) {
            this.row = row;
            this.ones = ones;
        }
    }
    public int numberOfBeams(String[] bank) {
        List<Pair> rowVsOnes = new ArrayList<>();
        for(int i=0;i<bank.length;i++) {
            String s = bank[i];
            int count = 0;
            for(char ch : s.toCharArray()) {
                if(ch == '1') {
                    count++;
                }
            }
            if(count != 0) {
                rowVsOnes.add(new Pair(i, count));
            }
        }

        if(rowVsOnes.size() < 1) {
            return 0;
        } else {
            int ans = 0;
            for(int i=0;i<rowVsOnes.size()-1;i++) {
                ans += (rowVsOnes.get(i).ones * rowVsOnes.get(i+1).ones);
            }
            return ans;
        }
    }
}