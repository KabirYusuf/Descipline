package regularExpression;

public class Main {
    public static void main(String[] args) {
        String string  = "I am a string. yes, I am";
        System.out.println(string);
        String yourString = string.replaceAll("I","you");
        System.out.println(yourString);

        String alphaNumeric ="abcdF1299z";
        System.out.println(alphaNumeric.replaceAll(".","Y"));

    }
}
