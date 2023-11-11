package es.iessoterohernandez.daw.endes;

public class Fibonacci {

	public static int[] fibonacci(int number) {

        int[] sequence = new int[number];
        sequence[0] = 0;

        if (number > 1) sequence[1] = 1;

        for (int i = 2; i < number; i++) {
        	sequence[i] = sequence[i - 1] + sequence[i - 2];
        }

        return sequence;

    }

}