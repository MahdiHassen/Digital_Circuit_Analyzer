package Components;

import MainEssentials.Node;

public class Component {

    private int ID = compID++;
    public static int compID = 0;
    protected int num_in, num_out;
    private String description = "no description provided";
    protected String name = "no name provided";

    public Component(int num_in, int num_out){
        this.num_in =  num_in;
        this.num_out = num_out;
    }

    public Component() {
    }

    public int getID(){
        return this.ID;
    }

    public int getNum_in() {
        return num_in;
    }

    public int getNum_out() {
        return num_out;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String info(){


        return "Component Name: " + this.name + "\n Desc:" + this.description + "\n Num Ins: " + num_in + " ,Num outs: " + num_out;
    }

    public void run(){
        System.out.println("no run function");
    }



    public static void main(String[] args) throws Exception { //test node ID and val

        Node node1 = new Node();
        node1.setVal(1);
        Node node2 = new Node();
        node2.setVal(0);
        Node node3 = new Node();
        and_2in andGate = new and_2in(node1, node2, node3);

        andGate.run();


        and_2in andGate2 = new and_2in(node1, node3, node1);
        andGate2.run();



        System.out.println("in: " + andGate2.getID() );
        System.out.println("in: " + andGate.getID() );

    }
}
