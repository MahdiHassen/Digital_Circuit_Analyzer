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


//test this
    void addNode (int ID){

        if (ID > (numNodes - 1)){

            for (int i = 0; i < ID + 1; i++ ){
                nodeList.add(new Node());}
            numNodes = ID + 1;
        }


    }

//test this
    public String toString(){

        String string = "";

        for (int i = 0 ; i < compList.size(); i++){
            string = string + "\n" + compList.get(i).toString();
        }
        return string;
    }


    public static void main(String[] args) { //test Ciruit


        Circuit cir = Circuit.getInstance();
        cir.addNode(3);


    }
}
