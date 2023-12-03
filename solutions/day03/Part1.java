package solutions.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Pattern pattern = Pattern.compile("\\d+");
        Scanner in = new Scanner(new File("inputs/day03.txt"));

        int sum = 0;
        ArrayList<String> lines = new ArrayList<>();
        while (in.hasNextLine()) {
            lines.add(in.nextLine());
        }
        int n = lines.size();
        for (int i = 0; i < n; i++) {
            String s = lines.get(i);
            Matcher matcher = pattern.matcher(s);

            outer: while (matcher.find()) {
                for (int j = Math.max(i - 1, 0); j <= Math.min(i + 1, n - 1); j++) {
                    String line = lines.get(j).substring(Math.max(matcher.start() - 1, 0),
                            Math.min(matcher.end() + 1, lines.get(j).length()));
                    if (line.matches("[\\d.]*?[^\\d.][\\d.]*")) {
                        sum += Integer.parseInt(matcher.group());
                        lines.set(i,
                                s.substring(0, matcher.start()) + ".".repeat(matcher.end() - matcher.start())
                                        + s.substring(matcher.end()));
                        continue outer;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
