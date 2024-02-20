import java.util.Scanner;

public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new LinkedBag<>();
        Scanner console = new Scanner("100 99 101 120 98 107 109 81 101 90");
        while (console.hasNextDouble()) {
            numbers.add(console.nextDouble());
        }
        console.close();

        int count = 0;
        double sum = 0;
        double sumOfSquares = 0;

        for (double num : numbers) {
            count++;
            sum += num;
            sumOfSquares += num * num;
        }

        double mean = sum / count;
        double variance = (sumOfSquares / count) - (mean * mean);
        double stddev = Math.sqrt(variance);

        // Print numbers
        for (double num : numbers) {
            System.out.println(num);
        }

        // Print mean and standard deviation
        System.out.printf("%nMean: %.2f%n", mean);
        System.out.printf("Stddev: %.2f%n", stddev);
    }
}