class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");

        StringBuilder sb = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();
        for(String s : arr) {
            if(s.length() == 0) {
                // case of multiple slashes
                continue;
            } else {
                if(s.equals(".")) {
                    continue;
                } else if(s.equals("..")) {
                    if(stack.size() > 0) {
                        stack.removeFirst();
                    }
                } else {
                    stack.addFirst(s);
                }
            }
        }

        List<String> list = new ArrayList<>();
        while(stack.size() > 0) {
            list.add(stack.removeFirst());
        }
        Collections.reverse(list);
        sb.append("/");
        for(String s : list) {
            sb.append(s);
            sb.append("/");
        }
        if(sb.length() == 1) {
            return sb.toString();
        }

        return sb.toString().substring(0, sb.length()-1);

    }
}