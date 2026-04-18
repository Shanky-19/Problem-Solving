class Solution {
    public int mirrorDistance(int n) {
        StringBuilder str = new StringBuilder();
        str.append(n);
        long reverse = Long.parseLong(str.reverse().toString());

        return (int) Math.abs(reverse - n);
    }
}