import java.util.Scanner;

/**
 * class used to test the linked bag class
 *
 * @author Huy Nguyen
 * @version 1.0
 */
public class Stats {
    public static void main(String[] args) {
        Bag<Double> bag = new LinkedBag<>();
        Scanner in = new Scanner("100 99 101 120 98 107 109 81 101 90");
        while (in.hasNextDouble()) {
            bag.add(in.nextDouble());
        }
        double sum = 0.0;
        for (double x : bag) {
            sum += x;
        }
        double mean = sum / bag.size();

        sum = 0.0;
        for (double x : bag) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (bag.size() - 1));

        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);
    }
}
