import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;


class MazesTests {



    @ParameterizedTest
    @CsvSource({"input1.txt, expected1.txt","input2.txt, expected2.txt", "input3.txt, expected3.txt","input4.txt, expected4.txt","input5.txt, expected5.txt","input6.txt, expected6.txt"})
    void test(String mazeNameInput, String mazeNameExpected) throws IOException {
        Route route = new Route();
        char[][] result = Parser.parseFile(mazeNameInput);
        char[][] expected = Parser.parseFile(mazeNameExpected);
        char[][] actual = route.searchRoute(result);
        Assertions.assertArrayEquals(expected,actual);
    }
}
