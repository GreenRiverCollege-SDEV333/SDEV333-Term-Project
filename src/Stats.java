import java.util.Scanner;

/**
 * Tests the LinkedBag class. Takes in a string of numbers
 * using the scanner class. Calculates the mean and standard
 * deviation, and prints it to the console.
 *
 * @author Will Castillo
 */
public class Stats
{
    /**
     * Tests for the LinkedBag
     * @param args Not used
     */
    public static void main(String[] args)
    {
        Bag<Double> numbers = new LinkedBag<>();

        Scanner in = new Scanner("100 99 101 120 98 107 109 81 101 90");

        while (in.hasNextDouble())
        {
            double number = in.nextDouble();
            numbers.add(number);
            System.out.printf("%.0f\n", number);
        }

        int size = numbers.size();

        double sum = 0.0;
        for (double x : numbers)
        {
            sum += x;
        }

        double mean = sum / size;

        sum = 0.0;
        for (double x : numbers)
        {
            sum += (x - mean) * (x - mean);
        }

        double stddev = Math.sqrt(sum / (size - 1));

        System.out.println();
        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Stddev: %.2f\n", stddev);
    }
}
