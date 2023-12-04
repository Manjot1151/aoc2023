package solutions.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day04.txt"));
        int win = 10;
        int have = 25;
        int totalPoints = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            line = line.substring(line.indexOf(":") + 2).replace("|", "");
            HashSet<Integer> winSet = new HashSet<>();
            Scanner lineIn = new Scanner(line);
            for (int i = 0; i < win; i++) {
                winSet.add(lineIn.nextInt());
            }
            int points = 1;
            for (int i = 0; i < have; i++) {
                if (winSet.contains(lineIn.nextInt())) {
                    points *= 2;
                }
            }
            lineIn.close();
            totalPoints += points / 2;
        }
        System.out.println(totalPoints);
    }
}
