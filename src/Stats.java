import java.util.Scanner;

public class Stats
{
    public static void main(String[] args)
    {
        Bag<Double> numbers = new LinkedBag<>();

        Scanner in = new Scanner("100 99 101 120 98 107 109 81 101 90");

        System.out.println("% java stats");

        while(in.hasNextDouble()){
            Double current = in.nextDouble();
            System.out.println(current);
            numbers.add(current);
        }

        double sum = 0.0;

        for (double x : numbers){
            sum += x;
        }

        double mean = sum/numbers.size();

        sum = 0.0;

        for (double x : numbers){
            sum += (x - mean)*(x - mean);
        }

        double std = Math.sqrt(sum/(numbers.size()-1));

        System.out.println();

        System.out.println("Mean: " + mean);
        System.out.println("Std dev: " + std);
    }
}
