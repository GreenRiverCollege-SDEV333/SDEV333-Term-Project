import java.util.Scanner;

/**
 * LinkedBag test client for term-project assignment 2 to implement and test a Stack ADT class, LinkedBag.
 *
 * @author Rob Smith
 * @version 1.0
 */
public class Stats {
    public static void main(String[] args) {

        Bag<Double> numbers = new LinkedBag<>();
        Scanner in = new Scanner("100 99 101 120 98 107 109 81 101 90");
        while (in.hasNextDouble()) {
            numbers.add(in.nextDouble());
        }
        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / numbers.size();

        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (numbers.size() - 1));

        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);
    }

}
