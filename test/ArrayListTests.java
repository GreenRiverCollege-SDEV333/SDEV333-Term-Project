import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayListTests
{
        private static ArrayList testList;
        private static ArrayList emptyList;
        private static ArrayList oneList;

        public ArrayListTests()
        {
            testList = new ArrayList();
            //populating testList first
            testList.addFront("Time management courses");
            testList.addFront("Mindful stress reduction strategies");
            testList.addFront("\"808s & Heartbreak\" by Kanye West");
            testList.addFront("\"Geogaddi\" by Boards of Canada");
            testList.addFront("\"Scenery\" by Snail's House");

            //how about another album for oneList? Maybe a rock one this time...
            oneList = new ArrayList();
            oneList.addFront("\"Yoshimi Battles the Pink Robots\" by The Flaming Lips");

            //nothing to add for empty list :)
            emptyList = new ArrayList();
        }

        @Test
        void addFront()
        {
            //PEAR standards drive me nuts, pick one style of bracketing or the other and keep it consistent!

            //populated list; printing the first value, adding to the front, then printing the new first value
            System.out.println(testList.get(0));
            testList.addFront("\"Aja\" by Steely Dan");
            System.out.println(testList.get(0));

            //This is probably an unorthodox way of writing tests if it works, it works.
            System.out.println(oneList.get(0));
            oneList.addFront("\"D>E>A>T>H>M>E>T>A>L>\" by Panchiko");
            System.out.println(oneList.get(0));

            //...I think trying to print out a get for an empty list will throw an exception here.
            System.out.println("Is the empty list empty?" + emptyList.isEmpty());
            emptyList.addFront("\"Metaphorical Music\" by Nujabes");
            System.out.println(emptyList.get(0));
        }

        @Test
        void addBack() {
            //gotta do something like this again...
            System.out.println(testList.get(testList.size() -1));
            testList.addBack("\"Endtroducing...\" by DJ Shadow");
            System.out.println(testList.get(testList.size()));

            //now for oneList... running out of albums off the top of my head, gonna have to dive into my library soon
            System.out.println(oneList.get(oneList.size() -1));
            oneList.addBack("\"LONG SEASON\" by Fishmans");
            System.out.println(oneList.get(oneList.size()));

            emptyList.addBack("\"Before the Night\" by Home");
            System.out.println(emptyList.get(emptyList.size()));
        }

        @Test
        void add() {
            //Basically just testing with Strings, even though the class accepts other objects...
            System.out.println(testList.get(5));
            testList.add(5, "\"Jet Set Radio OST\" by Hideki Naganuma (and various others)");
            System.out.println(testList.get(5));

            System.out.println(oneList.get(1));
            oneList.add(1, "\"World is Yours\" by MASS OF THE FERMENTING DREGS");
            System.out.println(oneList.get(1));

            System.out.println(emptyList.get(0));
            emptyList.add(0, "\"Good News For People Who Love Bad News\" by Modest Mouse");
            System.out.println(emptyList.get(0));
        }

        @Test
        void removeFront() {
            System.out.println("Removed value: " + testList.removeFront());

            System.out.println("Removed value: " + oneList.removeFront());

            emptyList.removeFront();
        }

        @Test
        void removeBack() {
            System.out.println("Removed value: " + testList.removeBack());

            System.out.println("Removed value: " + oneList.removeBack());

            emptyList.removeBack();
        }

        @Test
        void remove() {
            System.out.println("Current value at index 3: " + testList.get(2));
            System.out.println("Removed value: " + testList.remove(2));

            System.out.println("Current value at index 0: " + oneList.get(0));
            System.out.println("Removed value: " + oneList.remove(0));

            emptyList.remove(0);
        }

        @Test
        void contains() {
            assertEquals(true, testList.contains("Time management courses"));
            assertEquals(false, oneList.contains("Oranges"));
            assertEquals(false, emptyList.contains("Anything, really"));
        }


        @Test
        void isEmpty() {
            assertEquals(false, testList.isEmpty());
            assertEquals(false, oneList.isEmpty());
            assertEquals(true, emptyList.isEmpty());
        }

}
