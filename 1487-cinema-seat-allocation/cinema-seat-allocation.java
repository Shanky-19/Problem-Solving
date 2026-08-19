class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // How many rows are there in reservesSeats.length -> only for these we have to check 
        // rest all are empty 
        // so we can simply find the grps from them 
        // 10 seats -> we have to choose grp of 4 -> 2 distinct we can have. 
        // 1 & 10 - seat are not included
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // max length can be 1e4. 
        for(int[] r: reservedSeats) {
            // we can always add 1 & 10 
            if(r[1] == 1 || r[1] == 10) {
                continue;
            } 
            if(map.containsKey(r[0])) {
                List<Integer> al = map.get(r[0]);
                al.add(r[1]);
                map.put(r[0], al);
            } else {
                List<Integer> al = new ArrayList<>();
                al.add(r[1]);
                map.put(r[0], al);
            }
        }

        int size = map.size(); // unique rows in map, 
        int rowsleft = n - size; // rows left from total rows which are completely empty 
        int ans = 2 * rowsleft; // each row contributes 2 seats. 

        for(Integer key : map.keySet()) {
            List<Integer> value = map.get(key);
        
            boolean block1 = true;
            boolean block2 = true;
            boolean block3 = true; 
            for(Integer x: value) {
                if(x >= 2 && x <= 5) {
                    block1 = false; 
                }
                if(x >= 4 && x <= 7) {
                    block2 = false; 
                }
                if(x >= 6 && x <= 9) {
                    block3 = false; 
                }
            }

            if(block1 && block3) {
                ans += 2; 
            } else if(block1 || block2 || block3) {
                ans += 1; 
            }

        }; 
        return ans; 
    }
}