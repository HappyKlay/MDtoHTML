package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtils {
    public static List<String> readFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
    }

    public static void writeFile(String filePath, String content) throws IOException {
        Files.writeString(Paths.get(filePath), content);
    }

    public static boolean exists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }
}
