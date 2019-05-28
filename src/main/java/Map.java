import java.awt.*;

class Map {

    private MapCell[][] Cells;
    private Point Start, Finish;

    Point getStart() {
        return Start;
    }


    Point getFinish() {
        return Finish;
    }


    private Map(MapCell[][] cells, Point start, Point finish) {
        Start = start;
        Finish = finish;
        Cells = cells;
    }


    MapCell[][] getCells() {
        return Cells;
    }

    static Map parseMap(char[][] input) {
        int xLength = input[0].length;
        int yLength = input.length;
        MapCell[][] mapCells = new MapCell[yLength][xLength];
        Point start = new Point(0, 0);
        Point finish = new Point(0, 0);
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                switch (input[y][x]) {
                    case '#':
                        mapCells[y][x] = MapCell.Wall;
                        break;
                    case '@':
                        start = new Point(y, x);
                        mapCells[y][x] = MapCell.Road;
                        break;
                    case '.':
                        mapCells[y][x] = MapCell.Road;
                        break;
                    case 'X':
                        mapCells[y][x] = MapCell.Road;
                        finish = new Point(y, x);
                        break;
                }
            }
        }
        return new Map(mapCells, start, finish);
    }
}
