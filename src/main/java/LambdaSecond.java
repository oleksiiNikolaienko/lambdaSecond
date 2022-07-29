import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class LambdaSecond {
    public static void main(String[] args) {
        var path = "1.txt";

        try {
            var file = Path.of(path);
            var size = Double.valueOf(Files.size(file)) / (1024 * 1024);
            var variable = Files.readString(file);
            var sorted = Stream.of(variable.split("[.,()\\[\\] \" \\?!: '\\n]"))
                    .filter(s -> s.length() > 5)
                    .collect(Collectors.toCollection(TreeSet::new));

            System.out.printf("File size: %.6f Mb \n", size);
            System.out.printf("Words count: %d \n", sorted.size());
            System.out.printf("Sorted words: %s \n", sorted);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
