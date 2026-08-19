class Solution {
    
    String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public void solve(int idx,String digits,StringBuilder sb,List<String> ans){
        
        if(idx == digits.length()){
            if(sb.length() > 0){
                ans.add(new String(sb));
            }
            return;
        }

        int ix = digits.charAt(idx) - '0';
        String str = arr[ix];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            sb.append(ch);
            solve(idx+1,digits,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        solve(idx,digits,sb,ans);
        return ans;
    }
}