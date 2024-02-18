package APIs;

import java.util.Scanner;

public class Stats
{
    public static void main(String[] args) {
        // setup storage bag
        Bag<Double> numbers = new LinkedBag<>();

        // setup scanner, taking in given string
        Scanner line = new Scanner("100 99 101 120 98 107 109 81 101 90");

        // run through line
        while (line.hasNextDouble()) {
            // get current item and add to bag
            numbers.add(line.nextDouble());
        }

        // track number of items in bag
        int size = numbers.size();

        // run through bag and add up all items
        double sum = 0.0;
        for (double currNum : numbers) {
            sum += currNum;
        }

        // get the mean of all numbers in bag
        double mean = sum / size;

        // clear total tracker and use again to calculate standard dev
        sum = 0.0;
        for (double currNum : numbers) {
            sum += (currNum - mean) * (currNum - mean);
        }

        double std = Math.sqrt(sum / (size - 1));

        // display calculation results
        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);
    }
}