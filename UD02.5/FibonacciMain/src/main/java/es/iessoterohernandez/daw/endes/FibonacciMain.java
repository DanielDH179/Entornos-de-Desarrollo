package es.iessoterohernandez.daw.endes;

import java.util.Arrays;

public class FibonacciMain {

    public static void main(String[] args) {

    	final int NUMBER = 23;
        int[] sequence = Fibonacci.fibonacci(NUMBER);

        System.out.println("F(" + NUMBER + ") = " + Arrays.toString(sequence));

    }

}
