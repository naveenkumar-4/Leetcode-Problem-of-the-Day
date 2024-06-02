class ScoreOfString {
    public static int scoreOfString(String s) {
        int score = 0;
        int n = s.length();
        for(int i=0; i<n-1; i++){
            int adjacentScore = Math.abs(s.charAt(i) - s.charAt(i+1));
            score += adjacentScore;
        }
        return score;
    }
    public static void main(String args[]){
        String s = "hello";
        int totalScore = scoreOfString(s);
        System.err.println(totalScore);
    }
}