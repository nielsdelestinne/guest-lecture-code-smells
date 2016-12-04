package be.cegeka.harrypotter.exercise;

public class Book {

    private BookType bookType;

    public Book(BookType bookType) {
        this.bookType = bookType;
    }

    public BookType getBookType() {
        return bookType;
    }
}
