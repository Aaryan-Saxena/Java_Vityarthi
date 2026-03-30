import java.util.*;

class Book {
    String title;
    boolean isIssued;

    Book(String title) {
        this.title = title;
        this.isIssued = false;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    books.add(new Book(title));
                    System.out.println("Book added!");
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book b : books) {
                            String status = b.isIssued ? "Issued" : "Available";
                            System.out.println(b.title + " - " + status);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    boolean found = false;

                    for (Book b : books) {
                        if (b.title.equalsIgnoreCase(issueTitle) && !b.isIssued) {
                            b.isIssued = true;
                            System.out.println("Book issued!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not available.");
                    }
                    break;

                case 4:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    boolean returned = false;

                    for (Book b : books) {
                        if (b.title.equalsIgnoreCase(returnTitle) && b.isIssued) {
                            b.isIssued = false;
                            System.out.println("Book returned!");
                            returned = true;
                            break;
                        }
                    }

                    if (!returned) {
                        System.out.println("Book not found or not issued.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
