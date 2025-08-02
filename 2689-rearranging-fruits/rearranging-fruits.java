/*
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int val : basket1) {
            if(map1.containsKey(val)) {
                map1.put(val, map1.get(val) + 1);
            } else {
                map1.put(val, 1);
            }
        }

        for(int val : basket2) {
            if(map2.containsKey(val)) {
                map2.put(val, map2.get(val) + 1);
            } else {
                map2.put(val, 1);
            }
        }

        // validation
        for(int key : map1.keySet()) {
            int freq1 = map1.get(key);
            int freq2 = 0;
            if(map2.containsKey(key)) {
                freq2 = map2.get(key);
            }

            if((freq1 + freq2)%2 != 0) {
                return -1;
            }
        }

        for(int key : map2.keySet()) {
            int freq2 = map2.get(key);
            int freq1 = 0;
            if(map1.containsKey(key)) {
                freq1 = map1.get(key);
            }

            if((freq1 + freq2)%2 != 0) {
                return -1;
            }
        }



        // after validation
        Map<Integer, Integer> basket1ToBasket2 = new HashMap<>();
        Map<Integer, Integer> basket2ToBasket1 = new HashMap<>();

        for(int key : map1.keySet()) {
            int freq1 = map1.get(key);
            int freq2 = 0;
            if(map2.containsKey(key)) {
                freq2 = map2.get(key);
            }

            if(freq1 > freq2) {
                basket1ToBasket2.put(key, (freq1 - freq2)/2);
            }
        }

        for(int key : map2.keySet()) {
            int freq2 = map2.get(key);
            int freq1 = 0;
            if(map1.containsKey(key)) {
                freq1 = map1.get(key);
            }

            if(freq2 > freq1) {
                basket2ToBasket1.put(key, (freq2 - freq1)/2);
            }
        }

        List<Integer> list1 = new ArrayList<>(basket1ToBasket2.keySet());
        List<Integer> list2 = new ArrayList<>(basket2ToBasket1.keySet());

        Collections.sort(list1);
        Collections.sort(list2, Collections.reverseOrder());

        // System.out.println(list1.size() + " " + list2.size());

        int ans = 0;

        // int i = 0;
        // int j = 0;
        // while(i < list1.size() && j < list2.size()) {
        //     ans += Math.min(list1.get(i), list2.get(j)) * 
        //             Math.min(basket1ToBasket2.get(list1.get(i)), basket2ToBasket1.get(list2.get(j)));
        //     i++;
        //     j++;
        // }

        while(basket1ToBasket2.size() > 0) {
            for(int key : basket1ToBasket2.keySet()) {
                int val1 = key;
                int val2 = list2.get(j);
                int minValue = Math.min(val1, val2);
                int minFreq = Math.min(basket1ToBasket2.get(list1.get(i)), basket2ToBasket1.get(list2.get(j)));

                ans += minValue * minFreq;
                basket1ToBasket2.put(val1, basket1ToBasket2.get(val1)-minFreq);
                if(basket1ToBasket2.get(val1) == 0) {
                    basket1ToBasket2.remove(val1);
                    list1.remove(val1);
                }

                basket2ToBasket1.put(val2, basket2ToBasket1.get(val2)-minFreq);
                if(basket2ToBasket1.get(val2) == 0) {
                    basket2ToBasket1.remove(val2);
                    list2.remove(val2);
                }
            }
        }
        return ans;

    }
}
*/

import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> totalCounts = new HashMap<>();
        for (int fruit : basket1) totalCounts.put(fruit, totalCounts.getOrDefault(fruit, 0) + 1);
        for (int fruit : basket2) totalCounts.put(fruit, totalCounts.getOrDefault(fruit, 0) + 1);

        long minVal = Long.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : totalCounts.entrySet()) {
            if (entry.getValue() % 2 != 0) return -1;
            minVal = Math.min(minVal, entry.getKey());
        }

        List<Long> fruits_to_swap = new ArrayList<>();
        Map<Integer, Integer> count1 = new HashMap<>();
        for (int fruit : basket1) count1.put(fruit, count1.getOrDefault(fruit, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : totalCounts.entrySet()) {
            int fruit = entry.getKey();
            int diff = count1.getOrDefault(fruit, 0) - (entry.getValue() / 2);
            for (int i = 0; i < Math.abs(diff); i++) {
                fruits_to_swap.add((long)fruit);
            }
        }
        
        Collections.sort(fruits_to_swap);

        long totalCost = 0;
        int swapsToMake = fruits_to_swap.size() / 2;
        for (int i = 0; i < swapsToMake; i++) {
            totalCost += Math.min(fruits_to_swap.get(i), 2 * minVal);
        }
        
        return totalCost;
    }
}