package phoneBook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    public static class Password {

        Pattern p;
        Matcher m;

        public static void main(String[] args) {
            validatePassword();
        }

        static private void validatePassword(){
            Pattern p = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}");
            Matcher m = p.matcher("tbAgj&997bh");
            System.out.println(m.find());
        }
    }
}
