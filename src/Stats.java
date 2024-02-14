/*
 * SDEV333 Best class :D
 * Ming Li
 */
import java.util.*;

public class Stats {
    public static void main(String[] args) {
        Scanner in = new Scanner("100 99 101 120 98 107 109 81 101 90");

        Bag<Double> numbers = new LinkedBag<>();

        while (in.hasNextDouble()) {
            double num = in.nextDouble();

            // Print out the num
            System.out.println(num);

            numbers.add(num);
        }

        int N = numbers.size();

        double sum = 0.0;

        for (double x : numbers)
            sum += x;

        double mean = sum/N;

        sum = 0.0;

        for (double x : numbers)
            sum += (x - mean)*(x - mean);

        double std = Math.sqrt(sum/(N-1));

        System.out.println("Mean: " + mean);
        System.out.println("Std dev: "+ std);
    }
}
