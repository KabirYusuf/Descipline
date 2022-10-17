package duplicateNumber;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicateNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] num = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

        boolean isNull = true;
        boolean isDuplicate = false;
        int count = 0;
        while (isNull){
                System.out.println("Enter a number");
                int userInput = scanner.nextInt();
                boolean isAValidNumber = userInput >= 10 && userInput <= 100;


            for (int i = 0; i < num.length; i++) {
                if(userInput == num[i]){
                    isDuplicate = true;
                    break;
                }
                else {
                    isDuplicate = false;
                }
            }
            if(isAValidNumber && !isDuplicate){
                num[count] = userInput;
                count++;
            }
            for (int j = 0; j < num.length; j++) {
                if(num[j] == -1){
                    isNull = true;
                    break;
                }
                else {
                    isNull = false;
                }

            }
            System.out.println(Arrays.toString(num));

        }
    }
}
