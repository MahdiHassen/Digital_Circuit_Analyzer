package MainEssentials;

import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    Node node0 = null;
    Node node1 = null;
    Node node2 = null;
    Node node3 = null;

    @Before
    public void setUp() {

        //test nodes

        node0 = new Node();
        node1 = new Node();
        node2 = new Node();
        node3 = new Node();


    }

    @Test
    public void testValChange(){

        assertTrue("Unset node should have a val change by default", node0.getValChange());

        node1.setVal(true); //set node1 high
        assertTrue("Node with new value set should have ValChange", node1.getValChange());

        node1.setVal(true); //set node1 high again, no change
        assertFalse("no change in value should occur", node1.getValChange());

        node1.setVal(false);
        assertTrue("Node value changes", node1.getValChange());

    }
}