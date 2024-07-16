public class Solution {
    public static int minOperations(String[] logs) {
        // Stack<String> st = new Stack<>();
        int minOperation = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (minOperation > 0) {
                    minOperation--;
                }
            } else if (!log.equals("./")) {
                // st.push(log.substring(0, log.length() - 1));
                minOperation++;
            }
        }
        // return st.size();
        return minOperation;
    }

    public static void main(String[] args) {
        String[] logs = { "d1/", "d2/", "../", "d21/", "./" };
        int minOperations = minOperations(logs);
        System.out.println(minOperations);
    }
}