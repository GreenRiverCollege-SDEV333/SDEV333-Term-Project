/**
 * Test client for LinkedBag
 *
 * @author Lillian Nelson
 * @version 1.0
 */
package test;
import lists.LinkedBag;

import java.util.Scanner;

public class Stats
{
    public static void main(String[] args)
    {
        LinkedBag<Double> numbers = new LinkedBag<Double>();
        Scanner in = new Scanner("100 99 101 107 109 81 101 90");
        while(in.hasNextLine())
        {
            numbers.add(in.nextDouble());

        }
        for (Double n : numbers)
        {
            System.out.println(n);
        }

    }
}
