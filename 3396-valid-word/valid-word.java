class Solution {
    public boolean isValid(String word) {
        word = word.toLowerCase();
        if(word.length() < 3) {
            return false;
        }

        int vowels = 0;
        int consonants = 0;
        for(char ch : word.toCharArray()) {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            }else if(ch - 'a' >= 0 && ch - 'a' < 26) {
                consonants++;
            }else if(!(ch - '0' >=0 && ch - '0' <= 9)) {
                return false;
            }
        }
        
        if(vowels > 0 && consonants > 0) {
            return true;
        }
        return false;
    }
}