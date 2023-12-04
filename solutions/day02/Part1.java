package solutions.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day02.txt"));
        HashMap<String, Integer> cubes = new HashMap<>();
        cubes.put("red", 12);
        cubes.put("green", 13);
        cubes.put("blue", 14);
        int sum = 0;
        int game = 0;
        outer: while (in.hasNextLine()) {
            game++;
            String s = in.nextLine();
            String[] a = s.substring(s.indexOf(":") + 2).split("\\W+");
            for (int i = 0; i < a.length; i += 2) {
                if (Integer.parseInt(a[i]) > cubes.get(a[i + 1])) {
                    continue outer;
                }
            }
            sum += game;
        }
        System.out.println(sum);
    }
}
