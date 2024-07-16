import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericCatalog<T extends LibraryItem> {
    private List<T> catalog;

    public GenericCatalog() {
        this.catalog = new ArrayList<>();
    }

    public void addItem(T item) {
        catalog.add(item);
        System.out.println("Item added: " + item);
    }

    public void removeItem(String itemID) {
        Optional<T> itemToRemove = catalog.stream().filter(item -> item.getItemID().equals(itemID)).findFirst();
        if (itemToRemove.isPresent()) {
            catalog.remove(itemToRemove.get());
            System.out.println("Item removed: " + itemToRemove.get());
        } else {
            System.out.println("Item with ID " + itemID + " not found.");
        }
    }

    public T getItemDetails(String itemID) {
        for (T item : catalog) {
            if (item.getItemID().equals(itemID)) {
                return item;
            }
        }
        System.out.println("Item with ID " + itemID + " not found.");
        return null;
    }

    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            catalog.forEach(System.out::println);
        }
    }
}
