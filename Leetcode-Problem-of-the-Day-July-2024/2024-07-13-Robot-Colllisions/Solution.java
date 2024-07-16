import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class Solution {
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            robots.add(new int[] { positions[i], healths[i], directions.charAt(i), i });
        }

        Collections.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robots) {
            if (robot[2] == 'R' || stack.isEmpty() || stack.peek()[2] == 'L') {
                stack.push(robot);
                continue;
            }

            if (robot[2] == 'L') {
                boolean add = true;
                while (!stack.isEmpty() && stack.peek()[2] == 'R' && add) {
                    int last_health = stack.peek()[1];
                    if (robot[1] > last_health) {
                        stack.pop();
                        robot[1] -= 1;
                    } else if (robot[1] < last_health) {
                        stack.peek()[1] -= 1;
                        add = false;
                    } else {
                        stack.pop();
                        add = false;
                    }
                }

                if (add) {
                    stack.push(robot);
                }
            }
        }

        List<int[]> resultList = new ArrayList<>(stack);
        resultList.sort(Comparator.comparingInt(a -> a[3]));

        List<Integer> result = new ArrayList<>();
        for (int[] robot : resultList) {
            result.add(robot[1]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] positions = { 5, 4, 3, 2, 1 };
        int[] healths = { 2, 17, 9, 15, 10 };
        String directions = "RRRRR";
        List<Integer> res = survivedRobotsHealths(positions, healths, directions);
        System.out.println(res);
    }
}