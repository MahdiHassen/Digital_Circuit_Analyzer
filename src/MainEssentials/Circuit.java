package MainEssentials;

import java.util.ArrayList;


public class Circuit {

    ArrayList<Object> compList= new ArrayList<Object>();
    ArrayList<Object> inPinList= new ArrayList<Object>();

    ArrayList<Node> nodeList = new ArrayList<Node>();

    int numNodes = 0;

    private static Circuit instance = null; public static Circuit getInstance() {
        if (instance == null)
        { instance = new Circuit(); }
        return instance; }
    private Circuit() {
    }

    void addComp (Component comp){

        compList.add(comp.getID(), comp);

    }

    void addNode (int ID){ // add any number of nodes

        if (ID > (numNodes - 1)){

            for (int i = 0; i < ID + 1; i++ ){
                nodeList.add(new Node());}
            numNodes = ID + 1;
        }
    }

    public void countUpPins(){



    }

    public String toString(){

        String string = "";

        for (int i = 0 ; i < compList.size(); i++){
            string = string + "\n" + compList.get(i).toString();
        }
        return string;
    }


    public static void main(String[] args) { //test Ciruit


        Circuit cir = Circuit.getInstance();
        Node n0 = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();

        and_2in and_gate = new and_2in(n0, n1, n2);
        and_gate.run();

        System.out.println(and_gate.toString());

    }
}
