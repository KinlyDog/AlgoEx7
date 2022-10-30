import org.junit.internal.requests.OrderingRequest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest {
    OrderedList list = new OrderedList<>(true);

    @Test
    void compare() {
    }

    @Test
    void add() {
    }

    @Test
    void find() {
        assertTrue(list.find(5) == null);
    }

    @Test
    void delete() throws Exception {
        assertTrue(!list.delete(5));
    }

    @Test
    void clear() {
    }

    @Test
    void count() {
    }

    @Test
    void getAll() {
    }
}