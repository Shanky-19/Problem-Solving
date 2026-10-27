class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length-1;
        int boats = 0;
        while(i <= j){
            int tempCap = people[i] + people[j];
            if(tempCap <= limit){
                i++;
                j--;
                boats++;
            }else{
                j--;
                boats++;
            }
        }
        return boats;
    }
}