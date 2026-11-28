class MyHashSet {

    int numBuckets;
    List<LinkedList<Integer>> buckets;

    private int getHashValue(int key) {
        return key % numBuckets;
    }

    public MyHashSet() {
        numBuckets = 15000;
        buckets = new ArrayList<>();

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        int index = getHashValue(key);
        LinkedList<Integer> list = buckets.get(index);

        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        int index = getHashValue(key);
        LinkedList<Integer> list = buckets.get(index);

        list.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = getHashValue(key);
        LinkedList<Integer> list = buckets.get(index);

        return list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */