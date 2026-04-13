import java.util.*;

public class App {

    private Map<Long, String> data = new HashMap<>();
    private long nextId = 1;

    // CREATE
    public Long create(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Value cannot be empty");
        }
        Long id = nextId++;
        data.put(id, value);
        return id;
    }

    // READ
    public String get(Long id) {
        return data.get(id);
    }

    // UPDATE
    public boolean update(Long id, String newValue) {
        if (data.containsKey(id)) {
            data.put(id, newValue);
            return true;
        }
        return false;
    }

    // DELETE
    public boolean delete(Long id) {
        return data.remove(id) != null;
    }

    // MAIN (optional but safe to write)
    public static void main(String[] args) {
        System.out.println("Application running...");
    }
}