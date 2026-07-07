class Solution {

    private boolean isUpperCase(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }

    public int numberOfSpecialChars(String word) {
        int n = word.length();
        Map<Character, List<Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++) {
            char ch = word.charAt(i);
            if(isUpperCase(ch)) {
                continue;
            } else {
                if(hm.containsKey(ch)) {
                    List<Integer> indices = hm.get(ch);
                    indices.add(i);
                    hm.put(ch, indices);
                } else {
                    List<Integer> indices = new ArrayList<>();
                    indices.add(i);
                    hm.put(ch, indices);
                }
            }
        }

        // System.out.println(hm);

        Set<Character> unique = new HashSet<>();
        for(int i=0;i<n;i++) {
            char ch = word.charAt(i);
            if(isUpperCase(ch)) {
                char lowerCase = (char) (ch + 32);
                if(hm.containsKey(lowerCase)) {
                    List<Integer> indices = hm.get(lowerCase);
                    int len = indices.size();
                    // System.out.println(hm);
                    // System.out.println(indices);
                    // System.out.println(ch + " " + i); 
                    // System.out.println(indices.get(len-1) + " " + i);
                    if(indices.get(len - 1) < i) {
                        indices.remove(len-1);
                        if(indices.size() == 0) {
                            hm.remove(lowerCase);
                        } else {
                            hm.put(lowerCase, indices);
                        }
                        
                        // System.out.println(hm);
                        unique.add(ch);
                    } else {
                        hm.remove(lowerCase);
                    }

                }
            } 
        }
        return unique.size();
    }
}