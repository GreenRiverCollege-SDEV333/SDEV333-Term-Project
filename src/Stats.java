import java.util.Scanner;

/**
 * Ryder Dettloff
 * test for linked bag implementation
 */
public class Stats {
    public static void main(String[] args) {
        //create new bag and add numbers into the bag
        LinkedBag<Double> numbers = new LinkedBag<>();
        Scanner in = new Scanner("100 99 101 120 98 107 109 81 101 90");
        while(in.hasNextDouble()) {
            numbers.add(in.nextDouble());
        }
        // get the sum of all the numbers to prepare to find the mean
        int bagSize = numbers.size();
        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        //find mean but dividing total of numbers bu the number of items in the bag
        double mean = sum / bagSize;
        //reset sum
        sum = 0.0;
        //now use mean to find the standard deviation
        for (double x : numbers) {
            sum += (x - mean)*(x - mean);
        }

        double standardDev = Math.sqrt(sum/(bagSize-1));
        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Standard deviation: %.2f\n", standardDev);
    }
}