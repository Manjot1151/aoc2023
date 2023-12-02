package solutions.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day01.txt"));
        long sum = 0;
        String[] digits = { null, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "0", "1", "2",
                "3", "4", "5", "6", "7", "8", "9" };
        while (in.hasNextLine()) {
            String s = in.nextLine();
            int minIndex = s.length();
            int maxIndex = -1;
            int first = -1;
            int last = -1;
            for (int i = 1; i < digits.length; i++) {
                int firstIndex = s.indexOf(digits[i]);
                int lastIndex = s.lastIndexOf(digits[i]);
                if (firstIndex == -1)
                    continue;
                if (firstIndex < minIndex) {
                    minIndex = firstIndex;
                    first = i % 10;
                }
                if (lastIndex > maxIndex) {
                    maxIndex = lastIndex;
                    last = i % 10;
                }
            }
            sum += first * 10 + last;
        }
        System.out.println(sum);
    }
}