class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] arr = new int[2];
        int i = 1;
        while (true) {
            int j = n - i;
            String str = j + "";
            String str2 = i + "";
            if(!(str.contains("0")) && !(str2.contains("0"))) {
                arr[0] = i;
                arr[1] = j;
                return arr;
            }
            i++;
        }
    }

}