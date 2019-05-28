import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Route implements Navigator {
    @Override
    public char[][] searchRoute(char[][] input) {
        Map map = Map.parseMap(input);
        SinglyLinkedList pathInLinkedList = findPath(map);
        if (pathInLinkedList == null)
            return null;
        List<Point> path = pathInLinkedList.ToList();
        for (Point point : path) {
            if (!point.equals(map.getStart()) && !point.equals(map.getFinish()))
                input[(int) point.getX()][(int) point.getY()] = '+';
        }
        return input;
    }

    private SinglyLinkedList findPath(Map map) {
        Point exit = map.getFinish();
        SinglyLinkedList firstPoint = new SinglyLinkedList(map.getStart(), null);
        HashSet<Point> visited = new HashSet<>();
        LinkedList<SinglyLinkedList> queue = new LinkedList<>();
        queue.add(firstPoint);
        while (queue.size() != 0) {
            SinglyLinkedList dequeued = queue.pollFirst();
            Point point = dequeued.Value;
            if (point.getX() < 0 || point.getX() >= map.getCells().length || point.getY() < 0
                    || point.getY() >= map.getCells()[0].length)
                continue;
            if (map.getCells()[(int) point.getX()][(int) point.getY()] != MapCell.Road) continue;
            visited.add(point);

            SinglyLinkedList newSinglyLinkedList = makePassageToNeighborPoints(exit, visited, queue, dequeued, point);
            if (newSinglyLinkedList != null) return newSinglyLinkedList;
        }
        return null;
    }

    private SinglyLinkedList makePassageToNeighborPoints
            (Point exit, HashSet<Point> visited, LinkedList<SinglyLinkedList> queue, SinglyLinkedList dequeued, Point point) {
        for (int dy = -1; dy <= 1; dy++)
            for (int dx = -1; dx <= 1; dx++) {
                Point newPoint = new Point((int) point.getX() + dx, (int) point.getY() + dy);
                if (visited.contains(newPoint)) continue;
                if (dx != 0 && dy != 0) continue;
                visited.add(newPoint);
                SinglyLinkedList newSinglyLinkedList =
                        new SinglyLinkedList(newPoint, dequeued);
                if (newPoint.equals(exit))
                    return newSinglyLinkedList;
                queue.add(newSinglyLinkedList);
            }
        return null;
    }


}
