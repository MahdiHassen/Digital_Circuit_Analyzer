package Components;

import MainEssentials.Node;



public class not_1in {

    private int ID = notID++;
    public static int notID = 0;

    Node in1, out;
    public int num_in = 1;
    public int num_out = 1;
    private String name = "not_1in";


    public not_1in(Node in1, Node out) {
        this.in1 = in1;
        this.out = out;


    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String toString(){

        return this.getID() + " " + this.getName() + " input nodes: " + in1.getID() + ", Output Nodes: " + out.getID();

    }

    public void run(){
        out.setVal(!in1.getVal());
    }
}