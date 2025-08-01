class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> pt = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        r1.add(1);
        pt.add(r1);
        if(n == 1) {
            return pt;
        }
        List<Integer> prev = new ArrayList<>();
        prev.addAll(r1);
        int currentLength = 2;
        for(int i=1;i<n;i++) {
            List<Integer> ri = new ArrayList<>(Arrays.asList(new Integer[currentLength]));
            ri.set(0, 1);
            ri.set(currentLength-1, 1);
            // System.out.println(i + " " + prev + " " + (ri));
            for(int j=1;j<currentLength-1;j++) {
                int prev1 = prev.get(j-1);
                int prev2 = prev.get(j);
                ri.set(j, prev1 + prev2);
            }
            currentLength++;
            pt.add(ri);
            prev = ri;
        }
        return pt;


    }
}