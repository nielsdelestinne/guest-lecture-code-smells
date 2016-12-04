package be.cegeka.harrypotter.exercise;

import java.util.ArrayList;
import java.util.HashMap;

public class BookService {

    public double shop(ArrayList<Book> b) {
        double[] percentages = {0, 5, 10, 20, 25};
        if(b.size() == 1) return 8;
        HashMap<BookType, Integer> bMap = new HashMap<>();
        // loop over books, make map of amount of books per type
        for(Book b1 : b) {
            bMap.put(b1.getBookType(),
                    bMap.get(b1.getBookType()) == null ? 1 : bMap.get(b1.getBookType()) + 1);
        }
        // based on how big the set of books is,
        // calculate the discount price!
        double percentage = percentages[bMap.size() - 1];
        double discountPrice = bMap.size() * 8 * ((100 - percentage) / 100);
        double otherPrice = 0;
        // caculate the total normal price without any discounts
        for(int amount : bMap.values()) {
            otherPrice += amount * 8;
        }
        // if there is a set of books (minimum 2 books), take the discountPrice
        // in account, ignore otherwise
        if(bMap.size() > 1) {
            return otherPrice + discountPrice - (bMap.size() * 8);
        } return otherPrice;
    }

}
