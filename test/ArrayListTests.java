import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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

            //Test list
            assertEquals("\"Scenery\" by Snail's House", testList.get(0));
            testList.addFront("\"Aja\" by Steely Dan");
            assertEquals("\"Aja\" by Steely Dan", testList.get(0));

            //One list
            assertEquals("\"Yoshimi Battles the Pink Robots\" by The Flaming Lips", oneList.get(0));
            oneList.addFront("\"D>E>A>T>H>M>E>T>A>L>\" by Panchiko");
            assertEquals("\"D>E>A>T>H>M>E>T>A>L>\" by Panchiko", oneList.get(0));

            //Empty list
            assertTrue(emptyList.isEmpty());
            emptyList.addFront("\"Metaphorical Music\" by Nujabes");
            assertEquals("\"Metaphorical Music\" by Nujabes", emptyList.get(0));
        }

        @Test
        void addBack() {
            //Test list
            assertEquals("Time management courses", testList.get(testList.size() -1));
            testList.addBack("\"Endtroducing...\" by DJ Shadow");
            assertEquals("\"Endtroducing...\" by DJ Shadow", testList.get(testList.size() -1));

            //One list
            assertEquals("\"Yoshimi Battles the Pink Robots\" by The Flaming Lips",
                    oneList.get(oneList.size() -1));
            oneList.addBack("\"LONG SEASON\" by Fishmans");
            assertEquals("\"LONG SEASON\" by Fishmans", oneList.get(oneList.size() -1));

            //Empty list
            assertTrue(emptyList.isEmpty());
            emptyList.addBack("\"Before the Night\" by Home");
            assertEquals("\"Before the Night\" by Home", emptyList.get(0));
        }

        @Test
        void add() {
            //Test list
            assertEquals("Mindful stress reduction strategies", testList.get(3));
            testList.add(3, "\"Jet Set Radio OST\" by Hideki Naganuma (and various others)");
            assertEquals("\"Jet Set Radio OST\" by Hideki Naganuma (and various others)", testList.get(3));

            //One list
            assertEquals("\"Yoshimi Battles the Pink Robots\" by The Flaming Lips", oneList.get(0));
            oneList.add(1, "\"World is Yours\" by MASS OF THE FERMENTING DREGS");
            assertEquals("\"World is Yours\" by MASS OF THE FERMENTING DREGS", oneList.get(1));

            assertTrue(emptyList.isEmpty());
            emptyList.add(0, "\"Good News For People Who Love Bad News\" by Modest Mouse");
            assertEquals("\"Good News For People Who Love Bad News\" by Modest Mouse", emptyList.get(0));
        }

        @Test
        void removeFront() {
            //Test list
            assertEquals("\"Scenery\" by Snail's House", testList.removeFront());

            //One list
            assertEquals("\"Yoshimi Battles the Pink Robots\" by The Flaming Lips", oneList.removeFront());

            //Empty list
            assertEquals("List is empty. Nothing to remove", emptyList.removeFront());
        }

        @Test
        void removeBack() {
            //Test list
            assertEquals("Time management courses", testList.removeBack());

            //One list
            assertEquals("\"Yoshimi Battles the Pink Robots\" by The Flaming Lips", oneList.removeBack());

            //Empty list
            assertEquals("List is empty. Nothing to remove", emptyList.removeBack());
        }

        @Test
        void remove() {
            //Test list
            assertEquals("\"808s & Heartbreak\" by Kanye West", testList.remove(2));

            //One list
            assertEquals("\"Yoshimi Battles the Pink Robots\" by The Flaming Lips", oneList.remove(0));

            //Empty list
            assertEquals("List is empty. Nothing to remove", emptyList.remove(0));
        }

        @Test
        void contains() {
            //Test list
            assertTrue(testList.contains("Time management courses"));

            //One list
            assertFalse(oneList.contains("Oranges"));

            //Empty list
            assertFalse(emptyList.contains("Anything, really"));
        }


        @Test
        void isEmpty() {
            //Test list
            assertFalse(testList.isEmpty());

            //One list
            assertFalse(oneList.isEmpty());

            //Empty list
            assertTrue(emptyList.isEmpty());
        }
}
