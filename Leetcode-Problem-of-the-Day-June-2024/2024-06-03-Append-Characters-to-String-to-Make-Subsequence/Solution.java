public class Solution{
    public static int appendCharacters(String s, String t){
        int sLength = s.length(), tLength = t.length();
        int sIndex = 0, tIndex = 0;
        while(sIndex < sLength && tIndex < tLength){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                tIndex++;
            }
            sIndex++;
        }

        return tLength-tIndex;

    }
    public static void main(String args[]){
        String s = "coaching";
        String t = "coding";
        int noOfCharacterToAppend = appendCharacters(s, t);
        System.err.println("No of Characters to append is: " + noOfCharacterToAppend);
    }
}