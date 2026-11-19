import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CafeOrderQueueTest {
    @Test
    void addCustomerIncreasesWaitingCount() {  
    CafeOrderQueue cafe = new CafeOrderQueue();

    cafe.addCustomer("Alice");

    assertEquals(1, cafe.getWaitingCount());
}

    @Test
    void serveCustomerFollowsFifoOrder() {
        CafeOrderQueue cafe = new CafeOrderQueue();

        cafe.addCustomer("Alice");
        cafe.addCustomer("Bob");
        cafe.addCustomer("Sara");

        assertEquals("Alice", cafe.serveCustomer());
        assertEquals("Bob", cafe.serveCustomer());
        assertEquals("Sara", cafe.serveCustomer());

        assertEquals(0, cafe.getWaitingCount());
    }

    @Test
    void serveCustomerReturnsNullWhenQueueIsEmpty() {
        CafeOrderQueue cafe = new CafeOrderQueue();

        assertNull(cafe.serveCustomer());
        assertEquals(0, cafe.getWaitingCount());
    }

    @Test
    void addCustomerIgnoresNullAndBlankNames() {
        CafeOrderQueue cafe = new CafeOrderQueue();

        cafe.addCustomer(null);
        cafe.addCustomer("");
        cafe.addCustomer("   ");

        assertEquals(0, cafe.getWaitingCount());
    }

    @Test
    void waitingCountDecreasesAfterServingCustomer() {
        CafeOrderQueue cafe = new CafeOrderQueue();

        cafe.addCustomer("Alice");
        cafe.addCustomer("Bob");

        cafe.serveCustomer();

        assertEquals(1, cafe.getWaitingCount());
    }
}