class Solution {
    public int maxProduct(int n) {
        List<Integer> al = new ArrayList<>();
        while(n > 0) {
            al.add(n%10);
            n = n/10;
        }
        Collections.sort(al);
        int size = al.size();
        int val1 = al.get(size-1);
        int val2 = al.get(size-2);
        return (val1 * val2);
    }
}