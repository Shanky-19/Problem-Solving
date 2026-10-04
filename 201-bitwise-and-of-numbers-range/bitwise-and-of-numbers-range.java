class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // Approach 1 
        /*
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
        */

        // Approach 2
        while(right > left) {
            right = (right&(right-1));
        }
        return right;

    }
}