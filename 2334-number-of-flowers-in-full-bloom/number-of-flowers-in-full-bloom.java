class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = people.length;
        int m = flowers.length;
        int[] ans = new int[n];
        int[] start = new int[m];
        int[] end = new int[m];
        for(int i=0;i<m;i++) {
            int[] flower = flowers[i];
            start[i] = flower[0];
            end[i] = flower[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i=0;i<n;i++) {
            int bloomed = 0;
            int low = 0;
            int high = m-1;
            int personsTime = people[i];

            while (low <= high) {
                int mid = low + (high - low)/2;
                if(start[mid] <= personsTime) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            bloomed = low;

            low = 0;
            high = m-1;
            int died = 0;
            while (low <= high) {
                int mid = low + (high - low)/2;
                if(end[mid] >= personsTime) {
                    died = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            died = low;

            ans[i] = bloomed - died;
        }
        return ans;
    }
}