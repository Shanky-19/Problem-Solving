class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for(int i=0;i<n;i++) {
            arr[i] = nums[i] + "";
        }

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (a+b).compareTo(b+a); // asc order
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--) {
            sb.append(arr[i]);
        }

        if(sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}