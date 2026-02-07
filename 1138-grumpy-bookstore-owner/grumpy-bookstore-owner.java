class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int[] temp = new int[n];
        for(int i=0;i<n;i++) {
            temp[i] = customers[i] * grumpy[i];
        }

        // max sum subarray of length minutes 
        int ansIdx = -1;
        int maxSum = 0;
        int i = 0;
        int j = 0;
        int tempSum = 0;
        while(j < n) {
            
            tempSum += temp[j];
            while (j - i + 1 > minutes) {
                tempSum -= temp[i];
                i++;
            }
            if(tempSum > maxSum) {
                maxSum = tempSum;
                ansIdx = i;
            }
            j++;
        }

        // System.out.println(ansIdx);

        int res = 0;
        if(ansIdx == -1) {
            for(int x=0;x<n;x++) {
                if(grumpy[x] == 0) {
                    res += customers[x];
                }
            }
        } else {
            for(int x=0;x<n;x++) {
                if((x < ansIdx || x >= ansIdx + minutes) && grumpy[x] == 0) {
                    res += customers[x];
                }
            }

            for(int x=ansIdx;x<ansIdx+minutes;x++) {
                res += customers[x];
            }
        }

        return res;

    }
}

/**
-> customers = [1,0,1,2,1,1,7,5]
-> grumpy    = [0,1,0,1,0,1,0,1]
AND
-> customers AND Grumpy = [0, 0, 0, 2, 0, 1, 0, 5]

here take max sum subarray of size minutes -> there ability
will be used
 */