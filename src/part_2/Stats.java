package part_2;

import java.util.Scanner;

/**
 * Class to test the LinkedBag class.
 *
 * @author Addison Farley
 * @version 1.0
 */
public class Stats
{
    public static void main(String[] args)
    {
        LinkedBag<Double> nums = new LinkedBag<>();

        Scanner in = new Scanner("100 99 101 120 98 107 109 81 101 90");

        while(in.hasNextDouble())
        {
            nums.add(in.nextDouble());
        }

        int N = nums.size();

        double sum = 0.0;

        for (double x : nums)
        {
            sum += x;
        }

        double mean = sum/N;

        sum = 0.0;

        for (double x : nums)
        {
            sum += (x - mean)*(x - mean);
        }

        double std = Math.sqrt(sum/(N-1));

        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);
    }
}
