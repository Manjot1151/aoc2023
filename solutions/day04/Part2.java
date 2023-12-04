package solutions.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day04.txt"));
        int win = 10;
        int have = 25;
        int n = 209;
        int[] cards = new int[n];
        Arrays.fill(cards, 1);
        int card = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            line = line.substring(line.indexOf(":") + 2).replace("|", "");
            HashSet<Integer> winSet = new HashSet<>();
            Scanner lineIn = new Scanner(line);
            for (int i = 0; i < win; i++) {
                winSet.add(lineIn.nextInt());
            }
            int cnt = 0;
            for (int i = 0; i < have; i++) {
                if (winSet.contains(lineIn.nextInt())) {
                    cnt++;
                }
            }
            for (int i = card + 1; i <= card + cnt; i++) {
                cards[i] += cards[card];
            }
            lineIn.close();
            card++;
        }
        System.out.println(Arrays.stream(cards).sum());
    }
}
