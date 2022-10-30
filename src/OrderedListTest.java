import org.junit.internal.requests.OrderingRequest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest {
    OrderedList listAsc = new OrderedList<>(true);
    OrderedList listDesc = new OrderedList<>(false);

    @Test
    void compare() {
        assertTrue(listAsc.compare(5, 6) == -1);
        assertTrue(listAsc.compare(8, 6) == 1);
        assertTrue(listAsc.compare(5, 5) == 0);

        assertTrue(listDesc.compare("123", "123") == 0);
        assertTrue(listDesc.compare("1234", "123") == 1);
        assertTrue(listDesc.compare("123", "1234") == -1);
    }

    @Test
    void add() {
        for (int i = 0; i < 5; i++) {
            listAsc.add(i);
        }

        assertTrue(listAsc.count() == 5);
        assertTrue(Integer.parseInt(listAsc.head.value.toString()) == 0);


        for (int i = 0; i < 5; i++) {
            listDesc.add(i);
        }

        assertTrue(listDesc.count() == 5);
        assertTrue(Integer.parseInt(listDesc.head.value.toString()) == 4);
        assertTrue(Integer.parseInt(listDesc.tail.value.toString()) == 0);
    }

    @Test
    void find() {
        assertTrue(listAsc.find(5) == null);
        assertTrue(listDesc.find(5) == null);

        for (int i = 0; i < 5; i++) {
            listAsc.add(i);
            listDesc.add(i);
        }

        assertTrue(listAsc.find(0) == listAsc.head);
        assertTrue(listDesc.find(4) == listDesc.head);
    }

    @Test
    void delete() {
        assertTrue(!listAsc.delete(5));

        for (int i = 0; i < 5; i++) {
            listAsc.add(i);
        }

        assertTrue(listAsc.delete(3));
        assertTrue(listAsc.find(3) == null);
    }

    @Test
    void clear() {
        for (int i = 0; i < 5; i++) {
            listAsc.add(i);
        }

        assertTrue(listAsc.count() == 5);

        listAsc.clear(true);

        assertTrue(listAsc.count() == 0);
    }

    @Test
    void count() {
        for (int i = 0; i < 10; i++) {
            listAsc.add(i);
        }

        assertTrue(listAsc.count() == 10);
    }
}