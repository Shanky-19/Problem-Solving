class Solution {
    public int minimizeXor(int num1, int num2) {
        int countOnes = 0;
        for(int i=0;i<32;i++) {
            if((num2 & (1<<i)) != 0) {
                countOnes++;
            } 
        }

        int x = 0;
        for(int i=31;i>=0 && countOnes > 0;i--) {
            int val = (num1 & (1<<i));
            if(val > 0) {
                x |= (1<<i);
                countOnes--;
            }
        }

        int i = 0;
        while(i<32 && countOnes > 0) {
            if((x & (1<<i)) == 0) {
                x |= (1<<i);
                countOnes--;
            }
            i++;
        }
        return x;
    }
}