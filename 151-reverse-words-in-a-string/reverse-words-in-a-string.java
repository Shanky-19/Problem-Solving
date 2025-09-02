class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int i = 0;
        int j = arr.length-1;
        while (i < j) {
            if (arr[i].length() == 0) {
                i++;
            } else if(arr[j].length() == 0) {
                j--;
            } else {
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x=0;x<arr.length;x++) {
            if(arr[x].length() > 0) {
                sb.append(arr[x]).append(" ");
            }
        }
        return sb.substring(0, sb.length()-1).toString();
        
    }
}