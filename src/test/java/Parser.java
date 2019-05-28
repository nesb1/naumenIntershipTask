import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

class Parser {
    static char[][] parseFile(String pathToFile) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(pathToFile)).getFile());
        String content = new String(Files.readAllBytes(file.toPath()));
        return parseString(content);
    }

    private static char[][] parseString(String text) {
        if (text.equals("null"))
            return null;
        String[] line = text.split("\n");
        char[][] lines = new char[line.length][line[0].length()];
        for (int i = 0; i < line.length; i++)
            for (int j = 0; j < line[0].length(); j++) {
                lines[i][j] = line[i].charAt(j);
            }
        return lines;
    }


}