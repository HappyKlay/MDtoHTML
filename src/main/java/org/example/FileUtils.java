package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUtils {
    public static String readFile(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath));
    }

    public static void writeFile(String filePath, String content) throws IOException {
        Files.writeString(Paths.get(filePath), content);
    }

    public static boolean exists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }
}
