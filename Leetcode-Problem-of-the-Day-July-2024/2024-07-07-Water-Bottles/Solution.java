public class Solution {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int totalBottles = numBottles;

        while (numBottles >= numExchange) {
            totalBottles += numBottles / numExchange;
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }

        return totalBottles;
    }

    public static void main(String[] args) {
        int numBottles = 9;
        int numExchange = 3;
        int numOfBottles = numWaterBottles(numBottles, numExchange);
        System.out.println(numOfBottles);
    }
}