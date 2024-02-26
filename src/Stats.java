import java.util.Scanner;
/**
 *
 * Test the methods in the Bag <E> interface
 * Test client for LinkedBag
 *
 *  Bag- Linked-list implementation
 * @author Kayley Young
 */
public class Stats {
    public static void main(String[] args) {

        Bag<Double> numbers = new LinkedBag<>();
        Scanner in = new Scanner("100 99 101 120 98 107 109 81 101 90");
        System.out.println("% java Stats");
        while (in.hasNextDouble()) {
            double value = in.nextDouble();
            System.out.printf("%.0f%n", value);
            numbers.add(value);
        }
        int item = numbers.size();

        double sum = 0.0;
        for (double x: numbers) {
            sum += x;
        }
        double mean = sum/item;

        sum = 0.0;
        for (double x: numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum/(item-1));
        System.out.printf("\nMean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);


    }
}
