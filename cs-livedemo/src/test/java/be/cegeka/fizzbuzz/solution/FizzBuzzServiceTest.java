package be.cegeka.fizzbuzz.solution;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzServiceTest {

    private FizzBuzzService fizzBuzzService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        fizzBuzzService = new FizzBuzzService();
    }

    @Test
    public void fizzBuzz() {
        String[] fizzBuzzSequence = fizzBuzzService.fizzBuzz(2);
        assertThat(fizzBuzzSequence).hasSize(2);
        assertThat(fizzBuzzSequence).containsExactly("1", "2");
    }

    @Test
    public void fizzBuzz_givenSequenceNumberLowerOrEqualThan1_thenThrowException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("SequenceNumber should be higher than 1");
        fizzBuzzService.fizzBuzz(1);
    }

    @Test
    public void fizzBuzz_whenNumberDivisibleBy3_thenPrintFizz() {
        String[] fizzBuzzSequence = fizzBuzzService.fizzBuzz(3);
        assertThat(fizzBuzzSequence).containsExactly("1", "2", "Fizz");
    }

    @Test
    public void fizzBuzz_whenNumberDivisibleBy5_thenPrintBuzz() {
        String[] fizzBuzzSequence = fizzBuzzService.fizzBuzz(5);
        assertThat(fizzBuzzSequence).containsExactly("1", "2", "Fizz", "4", "Buzz");
    }

    @Test
    public void fizzBuzz_whenNumberDivisibleBy3And5_thenPrintFizzBuzz() {
        String[] fizzBuzzSequence = fizzBuzzService.fizzBuzz(15);
        assertThat(fizzBuzzSequence[14]).isEqualTo("FizzBuzz");
    }

}