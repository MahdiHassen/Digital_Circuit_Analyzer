package Components;

import MainEssentials.Node;

public class and_2in extends Component{

    private final int ID = andID++;
    private static int andID = 0;
    Node in1, in2, out;


    public and_2in(Node in1, Node in2, Node out) {
        super(2,1,"and_2in", "N/A");


        this.in1 = in1;
        this.in2 = in2;
        this.out = out;


    }


    public int getID() {
        return ID;
    }

    @Override
    public String toString(){

        return this.getID() + " " + this.getName() + " input nodes: " + in1.getID() + ", " + in2.getID() + " Output Nodes: " + out.getID();

    }

    @Override
    public void run(){

        out.setVal(in1.getVal() & in2.getVal());
}
}
