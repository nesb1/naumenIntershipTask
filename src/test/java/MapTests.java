import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
class MapTests {
    @Test
    void ParseMapWorksCorrectly() {
        char[][] input = new char[][]{{'@', '.', '.'}, {'#', '#', 'X'}};
        Map map = Map.parseMap(input);

        Point expectedStart = new Point(0, 0);
        Point actualStart = map.getStart();
        Assertions.assertEquals(expectedStart, actualStart);

        Point expectedFinish = new Point(1, 2);
        Point actualFinish = map.getFinish();
        Assertions.assertEquals(expectedFinish, actualFinish);

        MapCell[][] expectedMapCell = new MapCell[][]{{MapCell.Road, MapCell.Road, MapCell.Road},{MapCell.Wall, MapCell.Wall, MapCell.Road}};
        MapCell[][] actualMapCell = map.getCells();
        Assertions.assertArrayEquals(expectedMapCell,actualMapCell);

    }
}
