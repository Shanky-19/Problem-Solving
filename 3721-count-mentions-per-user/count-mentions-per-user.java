class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] ans = new int[numberOfUsers];
        Collections.sort(events, (a, b) -> {
            if(Integer.parseInt(a.get(1)) == Integer.parseInt(b.get(1))) {
                return b.get(0).compareTo(a.get(0));
            } else {
                return Integer.parseInt(a.get(1))-Integer.parseInt(b.get(1));
            }
        });

        for(List<String> ls : events) {
            System.out.println(ls);
        }

        Map<Integer, Integer> offlineData = new ConcurrentHashMap<>();

        for(List<String> event : events) {
            String type = event.get(0);
            int time = Integer.parseInt(event.get(1));
            
            if(type.equalsIgnoreCase("MESSAGE")) {
                
                String mentions = event.get(2);
                if(mentions.equalsIgnoreCase("ALL")) {
                    for(int i=0;i<ans.length;i++) {
                        ans[i]++;
                    }
                } else {
                    // mark the eligible offlines as online
                    for(int id : offlineData.keySet()) {
                        int offTime = offlineData.get(id);
                        if(time - offTime >= 60) {
                            offlineData.remove(id);
                        }
                    }

                    if(mentions.equalsIgnoreCase("HERE")) {
                        for(int i=0;i<ans.length;i++) {
                            if(!offlineData.containsKey(i)) {
                                ans[i]++;
                            }
                        }
                    } else {
                        String[] ids = mentions.split(" ");
                        for(String s : ids) {
                            int id = Integer.parseInt(s.substring(2));
                            ans[id]++;
                        }
                    }
                }

            } else {
                offlineData.put(Integer.parseInt(event.get(2)), time);
            }
        }
        return ans;

    }
}