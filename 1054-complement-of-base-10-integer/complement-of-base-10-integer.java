class Solution {
    public int bitwiseComplement(int n) {
        // String str = Integer.toBinaryString(n);
        // System.out.println(str);
        // StringBuilder sb = new StringBuilder();
        // for(char ch : str.toCharArray()) {
        //     if(ch == '1') {
        //         sb.append('0');
        //     } else {
        //         sb.append('1');
        //     }
        // }
        // return Integer.parseInt(sb.toString(),2);




        if (n == 0) return 1;

        int length = (int)(Math.log(n) / Math.log(2)) + 1;

        int mask = (1 << length) - 1;

        return n ^ mask;
    }
}