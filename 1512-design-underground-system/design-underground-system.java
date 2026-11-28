
class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Stats {
        long totalTime = 0;
        int count = 0;
    }

    Map<Integer, CheckIn> checkIns;
    Map<String, Map<String, Stats>> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn in = checkIns.remove(id);

        int duration = t - in.time;

        routes.putIfAbsent(in.station, new HashMap<>());

        Map<String, Stats> destinations = routes.get(in.station);
        destinations.putIfAbsent(stationName, new Stats());

        Stats stats = destinations.get(stationName);
        stats.totalTime += duration;
        stats.count++;
    }

    public double getAverageTime(String startStation, String endStation) {
        Stats stats = routes.get(startStation).get(endStation);

        return (double) stats.totalTime / stats.count;
    }
}
