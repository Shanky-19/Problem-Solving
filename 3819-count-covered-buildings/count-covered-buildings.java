class Solution {
    class Pair {
        int min;
        int max;

        public Pair (int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, Pair> map1 = new HashMap<>();
        Map<Integer, Pair> map2 = new HashMap<>();
        for(int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            if(map1.containsKey(x)) {
                Pair p = map1.get(x);
                p.min = Math.min(y, p.min);
                p.max = Math.max(y, p.max);
                map1.put(x, p);
            } else {
                map1.put(x, new Pair(y,y));
            }

            if(map2.containsKey(y)) {
                Pair p = map2.get(y);
                p.min = Math.min(x, p.min);
                p.max = Math.max(x, p.max);
                map2.put(y, p);
            } else {
                map2.put(y, new Pair(x,x));
            }
        }
        // for each x : we now have max y and min y
        // for each y : we now have max x and min x
        int ans = 0;
        for(int[] b : buildings) {
            int x = b[0];
            int y = b[1];
            boolean xConditionSatified = false;
            boolean yConditionSatified = false;

            // check y
            Pair p1 = map1.get(x);
            if(p1.min < y && p1.max > y) {
                yConditionSatified = true;
            }

            // check y
            Pair p2 = map2.get(y);
            if(p2.min < x && p2.max > x) {
                xConditionSatified = true;
            }
            if(xConditionSatified && yConditionSatified) {
                ans++;
            }
        }
        return ans;
    }
}