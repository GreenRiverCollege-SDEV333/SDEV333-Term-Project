import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTests
{
    private static LinkedList testList;
    private static LinkedList emptyList;
    private static LinkedList oneList;

    public LinkedListTests()
    {
        testList = new LinkedList();
        //populating testList first
        testList.addFront("\"Mother Earth's Plantasia\" by Mort Garson");
        testList.addFront("\"In Rainbows\" by Radiohead");
        testList.addFront("\"FINAL FANTASY I Original Soundtrack\" by Nobuo Uematsu");
        testList.addFront("\"RUNNERS HIGH\" by The Pillows");
        testList.addFront("\"Summer Breeze\" by PIPER");

        //running out of albums to add here...
        oneList = new LinkedList();
        oneList.addFront("\"The Electric State\" by Simon Stalenhag");

        //nothing to add for empty list :)
        emptyList = new LinkedList();
    }

    @Test
    void addFront()
    {
        //Test list
        assertEquals("\"Summer Breeze\" by PIPER", testList.get(0));
        testList.addFront("\"The Grimm Robe Demos\" by Sunn O)))");
        assertEquals("\"The Grimm Robe Demos\" by Sunn O)))", testList.get(0));
        assertEquals("\"Summer Breeze\" by PIPER", testList.get(1));

        //One list
        assertEquals("\"The Electric State\" by Simon Stalenhag", oneList.get(0));
        oneList.addFront("\"Currents\" by Tame Impala");
        assertEquals(("\"Currents\" by Tame Impala"), oneList.get(0));
        assertEquals("\"The Electric State\" by Simon Stalenhag", oneList.get(1));

        //Empty list
        assertTrue(emptyList.isEmpty());
        emptyList.addFront("\"Heavy Weather\" by Weather Report");
        assertFalse(emptyList.isEmpty());
        assertEquals("\"Heavy Weather\" by Weather Report", emptyList.get(0));
    }

    @Test
    void addBack() {
        //Test list
        assertEquals("\"Mother Earth's Plantasia\" by Mort Garson", testList.get(testList.size() - 1));
        testList.addBack("\"Operation Doomsday\" by MF DOOM");
        assertEquals("\"Operation Doomsday\" by MF DOOM", testList.get(testList.size() - 1));
        assertEquals("\"Mother Earth's Plantasia\" by Mort Garson", testList.get(testList.size() - 2));

        //One list
        assertEquals("\"The Electric State\" by Simon Stalenhag", oneList.get(oneList.size() - 1));
        oneList.addBack("\"Nematophy\" by Windows 96");
        assertEquals("\"Nematophy\" by Windows 96", oneList.get(oneList.size() - 1));
        assertEquals("\"The Electric State\" by Simon Stalenhag", oneList.get(oneList.size() - 2));

        //Empty list
        assertTrue(emptyList.isEmpty());
        emptyList.addFront("\"Untitled (Moon)\" by Yuko Imada");
        assertFalse(emptyList.isEmpty());
        assertEquals("\"Untitled (Moon)\" by Yuko Imada", emptyList.get(0));
    }

    @Test
    void add() {
        //Test list
        assertEquals("\"Mother Earth's Plantasia\" by Mort Garson", testList.get(4));
        testList.add(4, "\"Selected Ambient Works 85-92\" by Aphex Twin");
        assertEquals("\"Selected Ambient Works 85-92\" by Aphex Twin", testList.get(4));
        assertEquals("\"Mother Earth's Plantasia\" by Mort Garson", testList.get(5));

        //One list
        assertEquals("\"The Electric State\" by Simon Stalenhag", oneList.get(0));
        oneList.add(0, "\"Strangeways, Here We Come\" by The Smiths");
        assertEquals("\"Strangeways, Here We Come\" by The Smiths", oneList.get(0));
        assertEquals("\"The Electric State\" by Simon Stalenhag", oneList.get(1));


        //Empty list
        assertTrue(emptyList.isEmpty());
        emptyList.addFront("\"Lifestylez Ov Da Poor & Dangerous\" by Big L");
        assertFalse(emptyList.isEmpty());
        assertEquals("\"Lifestylez Ov Da Poor & Dangerous\" by Big L", emptyList.get(0));
    }

    @Test
    void removeFront() {
        //Test list
        assertEquals("\"Summer Breeze\" by PIPER", testList.removeFront());

        //One list
        assertEquals("\"The Electric State\" by Simon Stalenhag", oneList.removeFront());

        //Empty list
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void removeBack() {
        //Test list
        assertEquals("\"Mother Earth's Plantasia\" by Mort Garson", testList.removeBack());

        //One list
        assertEquals("\"The Electric State\" by Simon Stalenhag", oneList.removeBack());

        //Empty list
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void remove() {
        //Test list
        assertEquals("\"RUNNERS HIGH\" by The Pillows", testList.remove(2));
        assertEquals("\"In Rainbows\" by Radiohead", testList.get(2));

        //One list
        assertEquals("\"The Electric State\" by Simon Stalenhag", oneList.remove(1));
        assertTrue(oneList.isEmpty());

        //Empty list
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void contains() {
        assertTrue(testList.contains("\"Summer Breeze\" by PIPER"));
        assertFalse(oneList.contains("Oranges"));
        assertFalse(emptyList.contains("Anything, really"));
    }


    @Test
    void isEmpty() {
        assertFalse(testList.isEmpty());
        assertFalse(oneList.isEmpty());
        assertTrue(emptyList.isEmpty());
    }
}
