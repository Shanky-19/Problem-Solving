class RandomizedSet {
    HashMap<Integer,Integer> hm;
    public RandomizedSet() {
        hm = new HashMap<>(); 
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)){
            return false;
        }else{
            hm.put(val,1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(hm.containsKey(val)){
            hm.remove(val);
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        Set<Integer> set = hm.keySet();
        int[] arr = new int[set.size()];
        int i=0;
        for(int val: set){
            arr[i] = val;
            i++;
        }
        Random rndNum =  new Random();
        int randNumber = rndNum.nextInt(arr.length);
        return arr[randNumber];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */