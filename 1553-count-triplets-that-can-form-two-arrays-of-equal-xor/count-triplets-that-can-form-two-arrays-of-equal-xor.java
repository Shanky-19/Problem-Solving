class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] cumXor = new int[n];
        cumXor[0] = arr[0];
        for(int i=1;i<n;i++) {
            cumXor[i] = cumXor[i-1] ^ arr[i]; 
        }
        int count = 0;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                for(int k=j;k<n;k++) {
                    int val1 = cumXor[j-1] ^ cumXor[i] ^ arr[i];
                    int val2 = cumXor[k] ^ cumXor[j-1];
                    if(val1 == val2) {
                        // System.out.println(i + " " + j + " " + k);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}