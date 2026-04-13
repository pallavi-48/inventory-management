import java.util.*;

public class App {

    private Map<String, Integer> data = new HashMap<>();

    // ADD PRODUCT (CREATE)
    public void create(String product, int quantity) {
        if (product == null || product.trim().isEmpty()) {
            throw new IllegalArgumentException("Product cannot be empty");
        }
        data.put(product, quantity);
    }

    // GET STOCK (READ)
    public int get(String product) {
        return data.getOrDefault(product, 0);
    }

    // UPDATE STOCK
    public boolean update(String product, int change) {
        if (data.containsKey(product)) {
            int newStock = data.get(product) + change;

            if (newStock < 0) {
                return false; // not enough stock
            }

            data.put(product, newStock);
            return true;
        }
        return false;
    }

    // DELETE PRODUCT
    public boolean delete(String product) {
        return data.remove(product) != null;
    }

    public static void main(String[] args) {
        System.out.println("Inventory App Running...");
    }
}