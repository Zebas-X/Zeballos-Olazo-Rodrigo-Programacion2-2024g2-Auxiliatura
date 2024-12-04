public class Main {
    public static void main(String[] args) {
        ElectricVehicle myEV = new ElectricVehicle("Tesla", "Model 3", 50000, 75, 500);
        myEV.start();
        myEV.displayInfo();
        myEV.displayRange();
        myEV.stop();

        Author author = new Author("J.K. Rowling");
        Book book1 = new Book("Harry Potter and the Sorcerer's Stone", author, 19.99);
        author.addBook(book1);
        author.addBook("Harry Potter and the Chamber of Secrets", 21.99);

        System.out.println("\nBooks by " + author.name + ":");
        for (Book book : author.getBooks()) {
            book.getInfo();
        }
    }
}
