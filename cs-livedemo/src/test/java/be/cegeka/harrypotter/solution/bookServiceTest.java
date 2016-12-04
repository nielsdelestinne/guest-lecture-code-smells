package be.cegeka.harrypotter.solution;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

@RunWith(MockitoJUnitRunner.class)
public class bookServiceTest {

//    Harry Potter Book Discount
//
//    One copy of any of the five books (We are not selling the final two books) costs 8 EUR.
//
//    If you buy 2 different books, you get a 5% discount on those two books.
//    If you buy 3 different books, you get a 10% discount.
//    If you buy 4 different books, you get a 20% discount.
//    If you buy all 5, you get a 25% discount.
//
//    Note: if you buy, say, four books, of which 3 are
//    different titles, you get a 10% discount on the 3 that
//    form part of a set, but the fourth book still costs 8 EUR.
//
//    Note: if you buy multiple books, which make multiple sets,
//    you only get a discount on your first set.
//    For example:
//      2 copies of the first book
//      2 copies of the second book
//    will cost 31.2 EUR. (15.2 + 16)

    private BookService bookService;

    @Before
    public void setUp() {
        bookService = new BookService();
    }

    @Test
    public void givenOneBook_whenCaculatingPrice_thenReturnBasePrice() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS));

        double priceOfBooks = bookService.calculatePrice(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(8);
    }

    @Test
    public void givenTwoDifferentBooks_whenCaculatingPrice_thenReturnPriceWith5pctDiscount() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PRISONER_OF_AZKABAN));

        double priceOfBooks = bookService.calculatePrice(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(15.2);
    }

    @Test
    public void givenThreeDifferentBooks_whenCaculatingPrice_thenReturnPriceWith10pctDiscount() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_GOBLET_OF_FIRE));

        double priceOfBooks = bookService.calculatePrice(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(21.6);
    }

    @Test
    public void givenFourDifferentBooks_whenCaculatingPrice_thenReturnPriceWith20pctDiscount() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_GOBLET_OF_FIRE),
                new Book(BookType.THE_ORDER_OF_THE_PHOENIX));

        double priceOfBooks = bookService.calculatePrice(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(25.6);
    }

    @Test
    public void givenFiveDifferentBooks_whenCaculatingPrice_thenReturnPriceWith25pctDiscount() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_GOBLET_OF_FIRE),
                new Book(BookType.THE_ORDER_OF_THE_PHOENIX),
                new Book(BookType.THE_PHILOSOPHERS_STONE));

        double priceOfBooks = bookService.calculatePrice(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(30);
    }

    @Test
    public void givenTwoIdenticalBooks_whenCaculatingPrice_thenReturnBasePriceWithoutDiscount() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_CHAMBER_OF_SECRETS));

        double priceOfBooks = bookService.calculatePrice(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(16);
    }

    @Test
    public void givenTwoTimesTheSameTwoDifferentBooks_whenCaculatingPrice_thenOnlyCaculateDiscountOnce() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_PRISONER_OF_AZKABAN));

        double priceOfBooks = bookService.calculatePrice(selectedBooks);

        assertThat(formatDecimalTwoDigits(priceOfBooks)).isEqualTo("31.2");
    }

    @Test
    public void givenANumberOfBooks_whenCaculatingPrice_thenReturnCorrectPrice() {
        ArrayList<Book> selectedBooks = newArrayList(
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_CHAMBER_OF_SECRETS),
                new Book(BookType.THE_PHILOSOPHERS_STONE),
                new Book(BookType.THE_PHILOSOPHERS_STONE),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_PRISONER_OF_AZKABAN),
                new Book(BookType.THE_ORDER_OF_THE_PHOENIX),
                new Book(BookType.THE_GOBLET_OF_FIRE));

        double priceOfBooks = bookService.calculatePrice(selectedBooks);

        assertThat(priceOfBooks).isEqualTo(54);
    }

    private String formatDecimalTwoDigits(double priceOfBooks) {
        return String.format("%s", priceOfBooks).substring(0, 4);
    }

}