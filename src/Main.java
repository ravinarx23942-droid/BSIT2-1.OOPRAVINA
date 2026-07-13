import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // ===== Book class =====
    static class Book {
        private final String title;
        private final String author;
        private boolean available;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.available = true; // a new book always starts on the shelf
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isBorrowed() {
            return !available;
        }

        public boolean borrow() {
            if (!available) {
                return false; // already checked out
            }
            available = false;
            return true;
        }

        public boolean returnBook() {
            if (available) {
                return false; // wasn't out in the first place
            }
            available = true;
            return true;
        }

        @Override
        public String toString() {
            return String.format("%s by %s [%s]",
                    title, author, available ? "Available" : "Borrowed");
        }
    }

    // ===== Library class =====
    static class Library {
        private final List<Book> catalog = new ArrayList<>();

        public void addBook(Book book) {
            catalog.add(book);
            System.out.println("\"" + book.getTitle() + "\" has been added to the library.");
        }

        public void listBooks() {
            if (catalog.isEmpty()) {
                System.out.println("The catalog is currently empty.");
                return;
            }

            System.out.println("---- Current Catalog ----");
            int number = 1;
            for (Book book : catalog) {
                System.out.println(number + ") " + book);
                number++;
            }
        }

        public void borrowBook(String title) {
            Book match = locate(title);
            if (match == null) {
                System.out.println("Could not find a book titled \"" + title + "\".");
            } else if (match.borrow()) {
                System.out.println("Checked out: " + match.getTitle());
            } else {
                System.out.println("\"" + match.getTitle() + "\" is already checked out.");
            }
        }

        public void returnBook(String title) {
            Book match = locate(title);
            if (match == null) {
                System.out.println("Could not find a book titled \"" + title + "\".");
            } else if (match.returnBook()) {
                System.out.println("Checked in: " + match.getTitle());
            } else {
                System.out.println("\"" + match.getTitle() + "\" isn't checked out, nothing to return.");
            }
        }

        public void searchBook(String title) {
            Book match = locate(title);
            if (match == null) {
                System.out.println("No matching book for \"" + title + "\".");
            } else {
                System.out.println("Match found -> " + match);
            }
        }

        private Book locate(String title) {
            for (Book book : catalog) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            return null;
        }
    }

    // ===== Program entry point =====
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();
        boolean keepGoing = true;

        while (keepGoing) {
            showMenu();
            System.out.print("Choice: ");
            String selection = input.nextLine().trim();

            switch (selection) {
                case "1":
                    System.out.print("Title: ");
                    String newTitle = input.nextLine();
                    System.out.print("Author: ");
                    String newAuthor = input.nextLine();
                    library.addBook(new Book(newTitle, newAuthor));
                    break;

                case "2":
                    library.listBooks();
                    break;

                case "3":
                    System.out.print("Title to borrow: ");
                    library.borrowBook(input.nextLine());
                    break;

                case "4":
                    System.out.print("Title to return: ");
                    library.returnBook(input.nextLine());
                    break;

                case "5":
                    System.out.print("Title to search: ");
                    library.searchBook(input.nextLine());
                    break;

                case "0":
                    System.out.println("Closing the library system. See you next time!");
                    keepGoing = false;
                    break;

                default:
                    System.out.println("That's not a valid option, try again.");
            }
        }

        input.close();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("===== Library Menu =====");
        System.out.println("1. Add a book");
        System.out.println("2. List all books");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. Search a book");
        System.out.println("0. Exit");
    }
}