class Solution {
    public boolean reorderedPowerOf2(int n) {
        List<Long> list = new ArrayList<>();
        long val = 1L;
        long max = (long) Math.pow(10,9);
        while (val <= max) {
            list.add(val);
            val *= 2;
        }
        
        Map<Integer, Integer> map1 = new HashMap<>();
        while(n > 0) {
            int lastDigit = n%10;
            n = n/10;
            map1.put(lastDigit, map1.getOrDefault(lastDigit, 0) + 1);
        }
        for(long value : list) {
            Map<Integer, Integer> map2 = new HashMap<>();
            while(value > 0) {
                int lastDigit = (int) value%10;
                value = value/10;
                map2.put(lastDigit, map2.getOrDefault(lastDigit, 0) + 1);
            }
            if(map1.equals(map2)) {
                return true;
            }
        }
        return false;
    }
}