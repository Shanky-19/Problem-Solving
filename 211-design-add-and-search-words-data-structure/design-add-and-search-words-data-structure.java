class WordDictionary {

    class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.children[ch-'a'] != null){
                node = node.children[ch-'a'];
            }else{
                TrieNode n = new TrieNode();
                node.children[ch-'a'] = n;
                node = n;
            }
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        boolean ans = searchHelper(word,root);
        return ans;
    }

    public boolean searchHelper(String word, TrieNode root){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(TrieNode n : node.children){
                    if(n != null && searchHelper(word.substring(i+1),n)){
                        return true;
                    }
                }
                return false;
            }else{
                if(node.children[ch-'a'] == null){
                    return false;
                }else{
                    node = node.children[ch-'a'];
                }
            }
        }
        return node.isEndOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */