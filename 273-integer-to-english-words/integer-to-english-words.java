class Solution {

    private void fillBelow10(Map<Integer, String> below10) {
        below10.put(0, "");
        below10.put(1, "One");
        below10.put(2, "Two");
        below10.put(3, "Three");
        below10.put(4, "Four");
        below10.put(5, "Five");
        below10.put(6, "Six");
        below10.put(7, "Seven");
        below10.put(8, "Eight");
        below10.put(9, "Nine");
    }

    private void fillBelow20(Map<Integer, String> below20) {
        below20.put(10, "Ten");
        below20.put(11, "Eleven");
        below20.put(12, "Twelve");
        below20.put(13, "Thirteen");
        below20.put(14, "Fourteen");
        below20.put(15, "Fifteen");
        below20.put(16, "Sixteen");
        below20.put(17, "Seventeen");
        below20.put(18, "Eighteen");
        below20.put(19, "Nineteen");
    }

    private void fillBelow100(Map<Integer, String> below100) {
        below100.put(1, "Ten");
        below100.put(2, "Twenty");
        below100.put(3, "Thirty");
        below100.put(4, "Forty");
        below100.put(5, "Fifty");
        below100.put(6, "Sixty");
        below100.put(7, "Seventy");
        below100.put(8, "Eighty");
        below100.put(9, "Ninety");
    }

    private String solve(int num) {
        if(num < 10) {
            return below10.get(num);
        }
        
        if(num < 20) {
            return below20.get(num);
        }

        if(num < 100) {
            String ans = below100.get(num/10);
            if(num%10 != 0) {
                ans += " " + below10.get(num%10);
            }
            return ans;
        }

        if(num < 1000) { // 879
            String ans=  solve(num/100) + " Hundred";
            if(num%100 != 0) {
                ans += " " + solve(num%100);
            }
            return ans;
        }

        if(num < 1000000) {
            String ans=  solve(num/1000) + " Thousand";
            if(num%1000 != 0) {
                ans += " " + solve(num%1000);
            }
            return ans;
        }

        if(num < 1000000000) {
            String ans=  solve(num/1000000) + " Million";
            if(num%1000000 != 0) {
                ans += " " + solve(num%1000000);
            }
            return ans;
        }

        // num >= 1000000000

        String ans = solve(num/1000000000) + " Billion";
        if(num%1000000000 != 0) {
            ans += " " + solve(num%1000000000);
        }
        return ans;
    }

    Map<Integer, String> below10;
    Map<Integer, String> below20;
    Map<Integer, String> below100;
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        below10 = new HashMap<>();
        below20 = new HashMap<>();
        below100 = new HashMap<>();
        fillBelow10(below10); 
        fillBelow20(below20);
        fillBelow100(below100);

        return solve(num);
    }
}