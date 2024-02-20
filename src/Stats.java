/**
 * Author : Levi Miller
 * file: Stats.java testing out bag implementation
 */
import java.util.Scanner;

public class Stats {

    public static void main(String[] args) {

        Scanner in = new Scanner("90 101 81 109 107 98 120 101 99 100");

        Bag<Double> numbers = new LinkedBag<>();
        while (in.hasNextDouble()) {
            numbers.add(in.nextDouble());
        }
        System.out.println("% java Stats");
        for (double x : numbers) {
            String noZero = String.format("%.0f", x);
            System.out.println(noZero);
        }
        int size = numbers.size();
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        double mean = sum / size;
        sum = 0.0;
        for (double x : numbers)
            sum += (x - mean) * (x - mean);
        double std = Math.sqrt(sum / (size - 1));
        System.out.println();
        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);
    }
}
