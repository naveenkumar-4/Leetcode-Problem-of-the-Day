public class Solution {
    public static int minMovesToSeat(int[] seats, int[] students){
        int moves = 0, seatIndex = 0, studentIndex = 0;
        int[] seatFreq = new int[101];
        int[] studentFreq = new int[101];
        for(int i=0; i<seats.length; i++){
            seatFreq[seats[i]]++;
            studentFreq[students[i]]++;
        }

        while(seatIndex < studentFreq.length){
            if(seatFreq[seatIndex] == 0){
                seatIndex++;
                continue;
            }
            if(studentFreq[studentIndex] == 0){
                studentIndex++;
                continue;
            }
            moves+=Math.abs(seatIndex - studentIndex);
            seatFreq[seatIndex]--;
            studentFreq[studentIndex]--;
        }
        return moves;
    }

    public static void main(String[] args) {
        int[] seats = {3,1,5};
        int[] students = {2,7,4};
        int moves = minMovesToSeat(seats, students);
        System.err.println(moves);
    }
}
