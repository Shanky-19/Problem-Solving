
class Solution {

    private boolean removeSenator(StringBuilder senate, char ch, int idx) {
        boolean loopAround = false;

        while (true) {

            if (idx == 0) {
                loopAround = true;
            }

            if (senate.charAt(idx) == ch) {
                senate.deleteCharAt(idx);
                break;
            }

            idx = (idx + 1) % senate.length();
        }

        return loopAround;
    }

    public String predictPartyVictory(String senate) {

        StringBuilder sb = new StringBuilder(senate);

        int R_Count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'R') {
                R_Count++;
            }
        }

        int D_Count = sb.length() - R_Count;
        int idx = 0;

        while (R_Count > 0 && D_Count > 0) {

            if (sb.charAt(idx) == 'R') {
                boolean checkRemoval = removeSenator(
                    sb, 'D', (idx + 1) % sb.length()
                );

                D_Count--;

                if (checkRemoval) {
                    idx--;
                }

            } else {
                boolean checkRemoval = removeSenator(
                    sb, 'R', (idx + 1) % sb.length()
                );

                R_Count--;

                if (checkRemoval) {
                    idx--;
                }
            }

            idx = (idx + 1) % sb.length();
        }

        return R_Count == 0 ? "Dire" : "Radiant";
    }
}
