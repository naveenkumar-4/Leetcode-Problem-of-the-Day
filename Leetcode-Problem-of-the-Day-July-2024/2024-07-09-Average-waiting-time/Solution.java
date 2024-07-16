public class Solution {
    public static double averageWaitingTime(int[][] customers) {
        double busyUpTill = 0, waitingTime = 0;
        int n = customers.length;
        for (int customer = 0; customer < n; customer++) {
            double arrival = customers[customer][0], time = customers[customer][1];
            waitingTime += Math.max(arrival, busyUpTill) + time - arrival;
            busyUpTill = Math.max(arrival, busyUpTill) + time;
        }
        return (waitingTime * 1.0) / n;
    }

    public static void main(String[] args) {
        int[][] customers = { { 1, 2 }, { 2, 5 }, { 4, 3 } };
        double averageWaitingTime = averageWaitingTime(customers);
        System.out.println(averageWaitingTime);
    }
}