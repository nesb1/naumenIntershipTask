import java.awt.*;
import java.util.ArrayList;

class SinglyLinkedList
{
    Point Value;
    private SinglyLinkedList Previous;
    private int Length;

    SinglyLinkedList(Point value, SinglyLinkedList previous)
    {
        Value = value;
        Previous = previous;
        Length = previous==null ? 1 : previous.Length+1;
    }

    ArrayList<Point> ToList()
    {
        ArrayList<Point> result = new ArrayList<>();
        result.add(Value);
        SinglyLinkedList pathItem = Previous;
        while (pathItem != null)
        {
            result.add(pathItem.Value);
            pathItem = pathItem.Previous;
        }
        return result;
    }
}