package solutions.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day01.txt"));
        int sum = 0;
        while (in.hasNextLine()) {
            String s = in.nextLine();
            s =  s.replaceAll("[^\\d]+", "");
            sum += Integer.parseInt(s.charAt(0) + ""  + s.charAt(s.length() - 1));
        }
        System.out.println(sum);
    }
}