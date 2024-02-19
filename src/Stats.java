import java.util.Scanner;

public class Stats {
    public static void main(String[] args)
    {
        Bag<Double> numbers = new LinkedBag<Double>();
        Scanner in = new Scanner("100 99 101 120 98 107 109 81 101 90");
        while(in.hasNextDouble()) {
            numbers.add(in.nextDouble());
        }
        int size = numbers.size();
        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum/size;
        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean)*(x - mean);
        }
        double std = Math.sqrt(sum/(size-1));
        System.out.printf("Mean: %.2f\n", mean);
        System.out.printf("Std dev: %.2f\n", std);
    }
}
