class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String op : operations) {
            if(op.charAt(0) == 'X') {
                if(op.charAt(1) == '-') {
                    x--;
                } else {
                    x++;
                }
            } else {
                if(op.charAt(0) == '-') {
                    --x;
                } else {
                    ++x;
                }
            }
        }
        return x;
    }
}