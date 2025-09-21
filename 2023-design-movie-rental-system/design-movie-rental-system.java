class MovieRentingSystem {
    Map<Long, Integer> priceMap;
    Map<Integer, TreeSet<int[]>> available;
    TreeSet<int[]> rented;

    private long key(int shop, int movie) {
        return ((long)shop << 20) | movie;
    }

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        available = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(key(shop, movie), price);
            available.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            })).add(new int[]{price, shop});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        int count = 0;
        for (int[] entry : available.get(movie)) {
            res.add(entry[1]);
            if (++count == 5) break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        available.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        rented.remove(new int[]{price, shop, movie});
        available.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int[] entry : rented) {
            res.add(Arrays.asList(entry[1], entry[2]));
            if (++count == 5) break;
        }
        return res;
    }
}