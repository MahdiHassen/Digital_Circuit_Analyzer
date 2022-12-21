package MainEssentials;

import java.util.ArrayList;


public class Circuit {

    ArrayList<Object> compList= new ArrayList<Object>();
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

    public String toString(){

        String string = "";

        for (int i = 0 ; i < compList.size(); i++){
            string = string + "\n" + compList.get(i).toString();
        }
        return string;
    }


    public static void main(String[] args) { //test Ciruit


        Circuit cir = Circuit.getInstance();
        cir.addNode(6);
        //and_2in comp0 = new and_2in(nodeList.get(1) ,2, 4 ,3);


    }
}
