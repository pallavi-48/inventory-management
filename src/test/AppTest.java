import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    // TEST CREATE + GET
    @Test
    void testCreateAndGet() {
        app.create("Item1", 10);
        assertEquals(10, app.get("Item1"));
    }

    // TEST STOCK INCREASE
    @Test
    void testIncreaseStock() {
        app.create("Item2", 5);
        boolean updated = app.update("Item2", 5);

        assertTrue(updated);
        assertEquals(10, app.get("Item2"));
    }

    // TEST STOCK DECREASE SUCCESS
    @Test
    void testDecreaseStockSuccess() {
        app.create("Item3", 10);
        boolean updated = app.update("Item3", -4);

        assertTrue(updated);
        assertEquals(6, app.get("Item3"));
    }

    // TEST STOCK DECREASE FAILURE
    @Test
    void testDecreaseStockFailure() {
        app.create("Item4", 3);
        boolean updated = app.update("Item4", -5);

        assertFalse(updated);
        assertEquals(3, app.get("Item4"));
    }

    // TEST DELETE
    @Test
    void testDelete() {
        app.create("Item5", 2);
        boolean deleted = app.delete("Item5");

        assertTrue(deleted);
        assertEquals(0, app.get("Item5"));
    }
}