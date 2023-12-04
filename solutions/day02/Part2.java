package solutions.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day02.txt"));
        int sum = 0;
        while (in.hasNextLine()) {
            HashMap<String, Integer> cubes = new HashMap<>();
            String s = in.nextLine();
            String[] a = s.substring(s.indexOf(":") + 2).split("\\W+");
            for (int i = 0; i < a.length; i += 2) {
                if (Integer.parseInt(a[i]) > cubes.getOrDefault(a[i + 1], 0)) {
                    cubes.put(a[i + 1], Integer.parseInt(a[i]));
                }
            }
            sum += cubes.values().stream()
                    .mapToInt(Integer::intValue)
                    .reduce((t, e) -> t * e)
                    .getAsInt();
        }
        System.out.println(sum);
    }
}
