package Components;

import MainEssentials.Node;

public class and_2in{

    private int ID = andID++;
    public static int andID = 0;
    Node in1, in2, out;
    public int num_in = 2;
    public int num_out = 1;
    private String name = "and_2in";

    public and_2in(Node in1, Node in2, Node out) {
        this.in1 = in1;
        this.in2 = in2;
        this.out = out;

    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String toString(){

        return this.getID() + " " + this.getName() + " input nodes: " + in1.getID() + ", " + in2.getID() + " Output Nodes: " + out.getID();

    }
    public void run(){
        out.setVal(in1.getVal() & in2.getVal());
}
}
