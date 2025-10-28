class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = N % 14;
        if (N == 0) N = 14;
        int[] res = new int[cells.length];
        for (int i = 0; i < N; i++) {
            res = convert(cells);
            // System.out.println(Arrays.toString(res)); // 
            cells = res;
        }
        return res;
    }
    
    private int[] convert(int[] cells) {
        int[] res = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) res[i] = 1;
            else {
                res[i] = 0;
            }
        }
        return res;
    }
}