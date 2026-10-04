class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int rightShifted = 0;
        while(left != right) {
            left = left>>1;
            right = right>>1;
            rightShifted++;
        }

        while(rightShifted-- > 0) {
            left = left<<1;
            right = right<<1;
        }
        return left;
    }
}