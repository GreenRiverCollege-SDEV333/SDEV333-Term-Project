import java.util.Scanner;

/**
 * Previews LinkedBag
 *
 * @author R.J. Trenchard
 * 2/15/2024
 */

public class Stats {
    public static void main(String[] args) {
        Scanner in = new Scanner("100 99 101 120 98 107 109 81 101 90");

        Bag<Double> numbers = new LinkedBag<>();

        while (in.hasNextDouble()) {
            numbers.add(in.nextDouble());
        }

        int n = numbers.size();

        double sum = 0f;

        for (double num : numbers) {
            sum += num;
        }

        double mean = sum / n;

        sum = 0.0;
        for (double num : numbers) {
            sum += (num - mean) * (num - mean);
        }
        double stddev = Math.sqrt(sum/(n-1));

        System.out.printf("Mean: %.2f\nStddev: %.2f", mean, stddev);
    }
}
