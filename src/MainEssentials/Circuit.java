package MainEssentials;

import Components.*;

import java.util.ArrayList;
import java.util.Objects;


public class Circuit {


    //list of components + list of each component + node list
    ArrayList<Object> compList = new ArrayList<Object>();
    ArrayList<and_2in> and_2inArrayList = new ArrayList<and_2in>();
    ArrayList<or_2in> or_2inArrayList= new ArrayList<or_2in>();
    ArrayList<not_1in> not_1inArrayList= new ArrayList<not_1in>();
    ArrayList<input_pin> inPinList= new ArrayList<input_pin>();
    ArrayList<output_pin> outPinList= new ArrayList<output_pin>();
    ArrayList<Node> nodeList = new ArrayList<Node>();

    int numNodes = 0;

    private static Circuit instance = null; public static Circuit getInstance() {
        if (instance == null)
        { instance = new Circuit(); }
        return instance; }
    private Circuit() {
    }

    void addNode (int ID){ // add any number of nodes

        if (ID > (numNodes - 1)){

            for (int i = 0; i < ID + 1; i++ ){
                nodeList.add(new Node());}
            numNodes = ID + 1;
        }
    }

    void addComp (and_2in comp){

        compList.add(comp);
        and_2inArrayList.add(comp);

    }

    void addComp (or_2in comp){

        compList.add(comp);
        or_2inArrayList.add(comp);

    }

    void addComp (not_1in comp){

        compList.add(comp);
        not_1inArrayList.add(comp);

    }
    public void addComp (input_pin pin){

        compList.add(pin);
        inPinList.add(pin);

    }

    public void addComp(output_pin pin){

        compList.add(pin);
        outPinList.add(pin);

    }


    public void countUp_unSet(){

        byte counter = 0b00000000;

        //not done

        }


    public String toString(){

        String string = "";

        for (int i = 0 ; i < compList.size(); i++){
            string = string + "\n" + compList.get(i).toString();
        }
        return string;
    }


    public void run(){

    }
    public static void main(String[] args) { //test Ciruit


    }
}
