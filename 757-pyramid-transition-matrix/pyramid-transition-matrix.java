class Solution {

    private boolean solve(String currBottom, Map<String, List<Character>> map, 
                        int idx, StringBuilder aboveLayer, 
                            Map<String, Boolean> memo) {
        if(currBottom.length() == 1) {
            return true;
        }

        String memoKey = currBottom + "_" + idx + "_" + aboveLayer.toString();
        if(memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        if(idx == currBottom.length()-1) {
            boolean res = 
                solve(aboveLayer.toString(), map, 0, new StringBuilder(), memo);
            memo.put(memoKey, res);
            return res;
        }

        String base = currBottom.substring(idx, idx+2);

        if(!map.containsKey(base)) {
            memo.put(memoKey, false);
            return false;
        }

        for(char ch : map.get(base)) {
            aboveLayer.append(ch);
            if(solve(currBottom, map, idx+1, aboveLayer, memo)) {
                memo.put(memoKey, true);
                return true;
            }
            aboveLayer.deleteCharAt(aboveLayer.length()-1);
        }

        memo.put(memoKey, false);
        return false;
    } 

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for(String str : allowed) {
            String key = str.substring(0, 2);
            char ch = str.charAt(2);
            if(map.containsKey(key)) {
                List<Character> list = map.get(key);
                list.add(ch);
                map.put(key, list);
            } else {
                List<Character> list = new ArrayList<>();
                list.add(ch);
                map.put(key, list);
            }
        }
        int idx = 0;
        StringBuilder aboveLayer = new StringBuilder();

        Map<String, Boolean> memo = new HashMap<>();
        boolean ans = solve(bottom, map, idx, aboveLayer, memo);
        return ans;
    }
}