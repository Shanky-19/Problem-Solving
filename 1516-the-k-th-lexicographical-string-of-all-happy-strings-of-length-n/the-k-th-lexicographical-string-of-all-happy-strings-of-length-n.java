class Solution {
    public String getHappyString(int n, int k) {
        if(n == 1){
            if(k == 1){
                return "a";
            }else if(k == 2){
                return "b";
            }else if(k == 3){
                return "c";
            }else{
                return "";
            }
        }
        int maxPossibleStrings = 3 * (int)Math.pow(2,n-1);
        if(k > maxPossibleStrings){
            return "";
        }
        int calls = 3;
        k--; // to match with index
        int prevCall = -1;
        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            int singlePart = maxPossibleStrings/calls;
            int nextCall = k/singlePart;

            if(nextCall == 0){
                if(prevCall == 0){
                    prevCall = 1;
                }else{
                    prevCall = 0;
                }
            }else if(nextCall == 1){
                if(prevCall == -1||prevCall == 2){
                    prevCall = 1;
                }else{
                    prevCall = 2;
                }
            }else{
                prevCall = 2;
            }
            sb.append((char)('a'+prevCall));
            maxPossibleStrings = singlePart;
            k -= (singlePart * nextCall);
            calls = 2;
        }
        return sb.toString();
    }
}