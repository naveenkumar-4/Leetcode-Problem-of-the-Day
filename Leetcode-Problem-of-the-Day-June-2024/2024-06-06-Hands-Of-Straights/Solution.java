import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Arrays.sort(hand);
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int card : hand){
            freq.put(card, freq.getOrDefault(card, 0)+1);
        }

        for(int card : hand){
            if(card >= 0){
                if(freq.get(card) == 0){
                    continue;
                }
                for(int i=0; i<groupSize; i++){
                    int currentCard = card+i;
                    if(freq.getOrDefault(currentCard, 0) == 0){
                        return false;
                    }
                    freq.put(currentCard, freq.getOrDefault(currentCard, 0)-1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        boolean res = isNStraightHand(hand, groupSize);
        System.err.println(res);
    }
}