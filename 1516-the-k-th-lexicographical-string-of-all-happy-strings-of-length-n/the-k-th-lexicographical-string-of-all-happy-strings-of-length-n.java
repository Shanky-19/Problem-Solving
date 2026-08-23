class Solution {
    String ans = "";
    int count = 0;

    private void solve(char[] arr, int n, int k, StringBuilder sb) {
        if (!ans.equals("")) {
            return;
        }

        if (sb.length() == n) {
            count++;

            if (count == k) {
                ans = sb.toString();
            }

            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == arr[i]) {
                continue;
            }

            sb.append(arr[i]);
            solve(arr, n, k, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        char[] arr = {'a', 'b', 'c'};
        StringBuilder sb = new StringBuilder();

        solve(arr, n, k, sb);

        return ans;
    }
}