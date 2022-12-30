package Components;

import MainEssentials.Node;

public class or_2in{

    private int ID = orID++;
    public static int orID = 0;

    Node in1, in2, out;
    public int num_in = 2;
    public int num_out = 1;

   private String name = "or_2in";

    public or_2in(Node in1, Node in2, Node out) {
        this.in1 = in1;
        this.in2 = in2;
        this.out = out;

    }

    public int getID() {
        return ID;
    }

    public String toString(){

        return this.getID() + " " + this.name + " ins: " + in1.getID() + " " + in2.getID() + " outs: " + out.getID();

    }

    public void run(){
        out.setVal(in1.getVal() || in2.getVal());
    }
}
