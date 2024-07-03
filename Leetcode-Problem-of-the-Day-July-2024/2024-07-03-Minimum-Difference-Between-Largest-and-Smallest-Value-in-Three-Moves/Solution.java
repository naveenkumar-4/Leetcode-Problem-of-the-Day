import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static int minDifference(int[] nums) {

        if (nums.length < 5) {
            return 0;
        }

        PriorityQueue<Integer> minHeapForMax = new PriorityQueue<>(4);
        PriorityQueue<Integer> maxHeapForMin = new PriorityQueue<>(4, Comparator.reverseOrder());

        for (int num : nums) {
            if (minHeapForMax.size() < 4) {
                minHeapForMax.add(num);
            } else if (num > minHeapForMax.peek()) {
                minHeapForMax.poll();
                minHeapForMax.add(num);
            }
            if (maxHeapForMin.size() < 4) {
                maxHeapForMin.add(num);
            } else if (num < maxHeapForMin.peek()) {
                maxHeapForMin.poll();
                maxHeapForMin.add(num);
            }
        }
        int minList[] = new int[4];
        int maxList[] = new int[4];
        for (int i = 3; i >= 0; i--) {
            maxList[i] = minHeapForMax.poll();
            minList[i] = maxHeapForMin.poll();
        }
        return Math.min(Math.min(maxList[3] - minList[0], maxList[0] - minList[3]),
                Math.min(maxList[2] - minList[1], maxList[1] - minList[2]));
    }

    public static void main(String[] args) {
        int nums[] = { 1, 0, 5, 10, 14 };
        int minDiff = minDifference(nums);
        System.out.println(minDiff);
    }
}