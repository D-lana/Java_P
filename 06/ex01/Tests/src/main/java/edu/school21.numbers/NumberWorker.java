package edu.school21.numbers;

public class NumberWorker {

    public static class IllegalNumberException extends RuntimeException {
        public IllegalNumberException(String description) {
            super(description);
        }
    }

    public int digitsSum(int number) {
        int     sum = 0;

        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return(sum);
    }

    public boolean isPrime(int number) throws IllegalNumberException {
        int		root;
        boolean	result = true;

        if (number <= 1) {
            throw new IllegalNumberException("Illegal Argument");
        }
        if (number % 2 == 0 && number != 2) {
            result = false;
        }
        else {
            root = (int)Math.sqrt(number);
            for (int i = 3; i <= root; i++) {
                if (number % i == 0) {
                    result = false;
                    break ;
                }
            }
        }
        return(result);
    }

}
