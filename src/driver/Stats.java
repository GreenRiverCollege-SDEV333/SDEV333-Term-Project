/**
 * Toby Goetz
 */

package driver;
import abstractDataTypes.LinkedBag;
import java.util.Scanner;

public class Stats
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner("100 99 101 120 98 107 109 81 101 90");
        LinkedBag<Double> bagOfNumbers = new LinkedBag<>();

        while (in.hasNext()) {
            bagOfNumbers.add(in.nextDouble());
        }
        int bagSize = bagOfNumbers.size();
        double sum = 0.0;

        for (double x : bagOfNumbers) {
            sum += x;
        }
        double mean = sum/bagSize;
        sum = 0.0;

        for (double x : bagOfNumbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum/(bagSize-1));

        System.out.println(bagOfNumbers);
        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);
    }
}
