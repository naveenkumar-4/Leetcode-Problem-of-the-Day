public class Solution {
    public static int countSeniors(String[] details) {
        int count = 0;
        for (String str : details) {
            int temp = Integer.parseInt(str.substring(11, 13));
            if (temp > 60) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] details = { "7868190130M7522", "5303914400F9211", "9273338290F4010" };
        int count = countSeniors(details);
        System.out.println(count);
    }
}