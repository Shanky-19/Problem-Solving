class Solution {

    class Pair{
        String word;
        int len;

        public Pair(String word,int len){
            this.word = word;
            this.len = len;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(beginWord,1));
        Set<String> set = new HashSet<>();
        for(String s: wordList){
            set.add(s);
        }
        // since we need shortest path -> BFS
        while(queue.size() > 0){
            Pair p = queue.removeFirst();
            String word = p.word;
            int len = p.len;

            if(word.equals(endWord)){
                return len;
            }
            
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] wordArr = word.toCharArray();
                    char replacingChar = ch;
                    wordArr[i] = replacingChar;
                    String replaced = new String(wordArr);

                    if(set.contains(replaced)){
                        set.remove(replaced);
                        queue.addLast(new Pair(replaced,len+1));
                    }
                }
            }
        }   
        return 0;
    }
}