package extreme;

import java.util.Scanner;

public class Extreme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter then number of times you want to input number: ");
        int numberOfTimes = scanner.nextInt();

        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        int maxNum = num;
        int minNum = num;

        while (numberOfTimes > 1){
            System.out.println("Enter a number: ");
            num = scanner.nextInt();
            if(num > maxNum)maxNum = num;
            if(num < minNum)minNum = num;
            numberOfTimes--;
        }

        System.out.println(maxNum);
        System.out.println(minNum);

        int sumNum = maxNum + minNum;
        System.out.println(sumNum);
    }
}
