class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        HashMap<Character,Integer> hm1 = new HashMap<>();        
        HashMap<Character,Integer> hm2 = new HashMap<>();

        for(int i=0;i<s1.length();i++){
            hm1.put(s1.charAt(i),hm1.getOrDefault(s1.charAt(i),0)+1);
        }
        
        for(int i=0;i<s1.length();i++){
            hm2.put(s2.charAt(i),hm2.getOrDefault(s2.charAt(i),0)+1);
        }

        if(hm1.equals(hm2)){
            return true;
        }else{
            int left = 0;
            int right = s1.length();
            while(right < s2.length()){
                hm2.put(s2.charAt(right),hm2.getOrDefault(s2.charAt(right),0)+1);
                hm2.put(s2.charAt(left),hm2.get(s2.charAt(left)) - 1);
                if(hm2.get(s2.charAt(left)) == 0){
                    hm2.remove(s2.charAt(left));
                }
                // System.out.println(hm2);
                if(hm1.equals(hm2)){
                    return true;
                }
                right++;
                left++;
            }
        }
                        
        return false;
        
    }
}