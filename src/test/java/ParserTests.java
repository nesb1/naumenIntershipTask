import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ParserTests {
    @Test
    void parseTextWorksCorrectlyWithGoodString() throws IOException {
        String pathToFile = "TextForParserTest.txt";
        char[][] actual = Parser.parseFile(pathToFile);
        char[][] expected = new char[][]{{'Я',' ','х','о','ч','у',' ','р','а','б','о','т','а','т','ь',' ','у',' ','в','а','с'},
                {'В','о','з','ь','м','и','т','е',' ','п','о','ж','а','л','у','й','с','т','а',':',')'}};
        Assertions.assertArrayEquals(expected,actual);
    }
}
