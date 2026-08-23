class Solution {

    private boolean solve(int idx, int n, boolean[] visited, int[] ans) {
        if (idx == ans.length) {
            return true;
        }

        if (ans[idx] != 0) {
            return solve(idx + 1, n, visited, ans);
        }

        for (int num = n; num >= 1; num--) {
            if (visited[num]) {
                continue;
            }

            if (num == 1) {
                ans[idx] = 1;
                visited[1] = true;

                if (solve(idx + 1, n, visited, ans)) {
                    return true;
                }

                visited[1] = false;
                ans[idx] = 0;
            } else {
                int idx2 = idx + num;

                if (idx2 >= ans.length || ans[idx2] != 0) {
                    continue;
                }

                ans[idx] = num;
                ans[idx2] = num;
                visited[num] = true;

                if (solve(idx + 1, n, visited, ans)) {
                    return true;
                }

                visited[num] = false;
                ans[idx] = 0;
                ans[idx2] = 0;
            }
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        boolean[] visited = new boolean[n + 1];
        int[] ans = new int[2 * n - 1];

        solve(0, n, visited, ans);

        return ans;
    }
}