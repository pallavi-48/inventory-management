import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    // TEST CREATE + READ
    @Test
    void testCreateAndGet() {
        Long id = app.create("Sample Data");
        assertNotNull(id);
        assertEquals("Sample Data", app.get(id));
    }

    // TEST UPDATE
    @Test
    void testUpdate() {
        Long id = app.create("Old Data");
        boolean updated = app.update(id, "New Data");

        assertTrue(updated);
        assertEquals("New Data", app.get(id));
    }

    // TEST DELETE
    @Test
    void testDelete() {
        Long id = app.create("Delete Me");
        boolean deleted = app.delete(id);

        assertTrue(deleted);
        assertNull(app.get(id));
    }
}