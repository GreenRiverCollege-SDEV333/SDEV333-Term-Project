import java.util.Scanner;

public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new LinkedBag<>();
        Scanner scan = new Scanner("100 99 101 120 98 107 109 81 101 90");
        while(scan.hasNext())
        {
            Double number = Double.parseDouble(scan.next());
            numbers.add(number);
        }
        int size = numbers.size();
        Double sum = 0.0;
        for (Double num : numbers) {
            sum += num;
        }
        Double mean = sum / size;

        for (Double number : numbers ) {
            System.out.println(number);
        }
        System.out.println("mean = " + mean);
    }
}
