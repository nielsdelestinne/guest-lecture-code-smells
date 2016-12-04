package be.cegeka.harrypotter.solution;

import java.util.ArrayList;
import java.util.HashMap;

public class BookService {

    public static final int BOOK_BASE_PRICE = 8;
    private static final double[] POSSIBLE_PERCENTAGES = {0, 5, 10, 20, 25};

    public double calculatePrice(ArrayList<Book> selectedBooks) {
        return getDiscountPriceForBooksInSet(getAmountOfBooksPerType(selectedBooks))
                + getPriceForRemainingBooks(selectedBooks, getAmountOfBooksPerType(selectedBooks));
    }

    private double getPriceForRemainingBooks(ArrayList<Book> selectedBooks, HashMap<BookType, Integer> amountOfBooksPerType) {
        return selectedBooks.size() * BOOK_BASE_PRICE - getPriceForBooksInSet(amountOfBooksPerType);
    }

    private int getPriceForBooksInSet(HashMap<BookType, Integer> amountOfBooksPerType) {
        return amountOfBooksPerType.size() * BOOK_BASE_PRICE;
    }

    private double getDiscountPriceForBooksInSet(HashMap<BookType, Integer> amountOfBooksPerType) {
        double percentageToApply = POSSIBLE_PERCENTAGES[amountOfBooksPerType.size() - 1];
        return amountOfBooksPerType.size() * BOOK_BASE_PRICE * ((100 - percentageToApply) / 100);
    }

    private HashMap<BookType, Integer> getAmountOfBooksPerType(ArrayList<Book> selectedBooks) {
        HashMap<BookType, Integer> amountOfBooksPerType = new HashMap<>();
        selectedBooks
                .forEach(book -> amountOfBooksPerType.put(book.getBookType(),
                    incrementOrInitAmountOfBooksPerType(amountOfBooksPerType, book))
                );
        return amountOfBooksPerType;
    }

    private int incrementOrInitAmountOfBooksPerType(HashMap<BookType, Integer> amountOfBooksPerType, Book book) {
        return isAmountNotSet(amountOfBooksPerType, book) ? 1 : incrementAmountOfBooksPerType(amountOfBooksPerType, book);
    }

    private int incrementAmountOfBooksPerType(HashMap<BookType, Integer> amountOfBooksPerType, Book book) {
        return amountOfBooksPerType.get(book.getBookType()) + 1;
    }

    private boolean isAmountNotSet(HashMap<BookType, Integer> amountOfBooksPerType, Book book) {
        return amountOfBooksPerType.get(book.getBookType()) == null;
    }

}
