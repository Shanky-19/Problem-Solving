class Solution {
    public int[] frequencySort(int[] arr) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n:arr){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) -> {
            if (map.get(a) != map.get(b)) {
                return map.get(a) - map.get(b);
            }
            return b - a;                   
        });

        int res[] = new int[arr.length];
        int index = 0;
        for(int n:list){
            int freq = map.get(n);
            for(int i = 0; i < freq; i++){
                res[index++] = n;
            }
        }

        return res;
    }
}