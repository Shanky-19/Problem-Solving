class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        int i = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        while(i < n) {
            char ch = s.charAt(i);
            String str = null;
            if(ch == '(') {
                int j = i;
                while(s.charAt(j) != ')') {
                    j++;
                }

                str = s.substring(i+1, j);
                i = j;
                // System.out.println(str);
            } else {
                sb.append(ch);
            }

            if(str != null) {
                if(map.containsKey(str)) {
                    sb.append(map.get(str));
                } else {
                    sb.append('?');
                }
                
            }
            i++;
        }
        return sb.toString();
    }
}