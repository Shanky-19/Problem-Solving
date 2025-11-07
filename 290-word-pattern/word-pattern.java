class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        HashMap<Character,String> hm = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(hm.containsKey(ch)){
                if(!arr[i].equals(hm.get(ch))){
                    return false;
                }
            }else{
                // System.out.println(ch + " " + i);
                if(set.contains(arr[i])){
                    return false;
                }
                hm.put(ch,arr[i]);
                set.add(arr[i]);
            }
        }
        return true;
    }
}