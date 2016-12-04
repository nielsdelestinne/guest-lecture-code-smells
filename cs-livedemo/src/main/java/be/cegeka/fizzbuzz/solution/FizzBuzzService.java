package be.cegeka.fizzbuzz.solution;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzService {

    public String[] fizzBuzz(int sequenceNumber) {
        validatePreconditions(sequenceNumber);
        return calculateFizzBuzz(sequenceNumber);
    }

    private void validatePreconditions(int sequenceNumber) {
        if(sequenceNumber <= 1) {
            throw new IllegalArgumentException("SequenceNumber should be higher than 1");
        }
    }

    private String[] calculateFizzBuzz(int sequenceNumber) {
        return IntStream
                .range(1, sequenceNumber+1)
                .mapToObj(fizzBuzzElement -> formatFizzBuzzElement(fizzBuzzElement))
                .collect(Collectors.toList())
                .toArray(new String[sequenceNumber]);
//        String[] fizzBuzzSequence = new String[sequenceNumber];
//        for(int i = 0; i < sequenceNumber; i++) {
//            fizzBuzzSequence[i] = formatFizzBuzzElement(i+1);
//        }
//        return fizzBuzzSequence;
    }

    private String formatFizzBuzzElement(int fizzBuzzElement) {
        if(fizzBuzzElement % 3 == 0 && fizzBuzzElement % 5 == 0) {
            return "FizzBuzz";
        }
        if(fizzBuzzElement % 3 == 0) {
            return "Fizz";
        }
        if(fizzBuzzElement % 5 == 0) {
            return "Buzz";
        }
        return String.format("%s", fizzBuzzElement);
    }
}
