package MainEssentials;

import Components.*;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircuitTest {

    //Circuit cir;
    Node n1,n2,n3,n4, n5;



    @Before
    public void setUp() {





    }

@Test
    public void testRun(){



    n1 = new Node();
    n2 = new Node();
    n3 = new Node();
    n4 = new Node();
    n5 = new Node();

    and_2in andGate = new and_2in(n1,n2,n3);





    Circuit cir = new Circuit();
    cir.addComp(andGate);

    assertFalse("output node should be unset",n3.getHasVal() );

    n1.setVal(true); n2.setVal(true);

    assertFalse("output node should be unset",n3.getHasVal() );

    //cir.run();
    //assertTrue("output node should be set",n3.getHasVal() );

    //assertFalse("output node should be 0", n3.getVal());

    //add not gate


    not_1in notGate = new not_1in(n3,n4);
    not_1in not2 = new not_1in(n4,n5);
    cir.addComp(notGate);
    cir.addComp(not2);

    cir.run();


    assertFalse(n4.getVal());





    //assertFalse("output node should be 0", n3.getVal());



}

}



