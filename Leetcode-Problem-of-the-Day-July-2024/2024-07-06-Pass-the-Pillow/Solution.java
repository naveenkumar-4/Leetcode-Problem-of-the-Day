public class Solution {
    public static int passThePillow(int n, int time) {
        int chunks = time / (n - 1);
        return chunks % 2 == 0 ? (time % (n - 1) + 1) : (n - time % (n - 1));
    }

    public static void main(String[] args) {
        int n = 4, time = 5;
        int index = passThePillow(n, time);
        System.out.println(index);

    }
}