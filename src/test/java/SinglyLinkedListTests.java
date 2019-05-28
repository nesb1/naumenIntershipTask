import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;


class SinglyLinkedListTests {
    @Test
    void toListWorksCorrectly() {
        SinglyLinkedList prevSinglyLinkedList = new SinglyLinkedList(new Point(0, 0), null);
        for (int i = 1; i < 10; i++) {
            prevSinglyLinkedList = new SinglyLinkedList(new Point(i, i), prevSinglyLinkedList);
        }
        ArrayList<Point> expected = new ArrayList<>();
        for (int i = 9; i >= 0; i--) {
            expected.add(new Point(i, i));
        }
        ArrayList<Point> actual = prevSinglyLinkedList.ToList();
        Assertions.assertEquals(expected, actual);

    }
}
