package edu.school21.numbers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberWorkerTest {
    NumberWorker numberWorker;

    @BeforeEach
    void beforeEach() {
        numberWorker = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = { 271, 131, 113, 13, 829 })
    void isPrimeForPrimes(int number) {
        Assertions.assertTrue(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = { 55, 10, 12, 6, 88 })
    void isPrimeForNotPrimes(int number) {
        Assertions.assertFalse(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, -1, -5, -11111 })
    void isPrimeForIncorrectNumbers(int number) {
        Assertions.assertThrows(NumberWorker.IllegalNumberException.class, () -> {
            numberWorker.isPrime(number);
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',')
    void checkDigitsSum(int number, int result) {
        Assertions.assertEquals(numberWorker.digitsSum(number), result);
    }
}