import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GenericCatalog<LibraryItem> catalog = new GenericCatalog<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Catalog Operations:");
            System.out.println("1. Add new library item");
            System.out.println("2. Remove library item");
            System.out.println("3. View item details");
            System.out.println("4. View entire catalog");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter item ID: ");
                    String itemID = scanner.nextLine();
                    catalog.addItem(new LibraryItem(title, author, itemID));
                    break;
                case 2:
                    System.out.print("Enter item ID to remove: ");
                    String removeID = scanner.nextLine();
                    catalog.removeItem(removeID);
                    break;
                case 3:
                    System.out.print("Enter item ID to view details: ");
                    String viewID = scanner.nextLine();
                    LibraryItem item = catalog.getItemDetails(viewID);
                    if (item != null) {
                        System.out.println(item);
                    }
                    break;
                case 4:
                    catalog.displayCatalog();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
