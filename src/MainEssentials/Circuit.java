package MainEssentials;

import Components.*;

import java.util.ArrayList;


public class Circuit {


    //list of components + list of each component + node list... should be one list of components that can be run
    ArrayList<Object> compList = new ArrayList<Object>();
    ArrayList<and_2in> and_2inArrayList = new ArrayList<and_2in>();
    ArrayList<or_2in> or_2inArrayList= new ArrayList<or_2in>();
    ArrayList<not_1in> not_1inArrayList= new ArrayList<not_1in>();
    ArrayList<input_pin> inPinList= new ArrayList<input_pin>();
    ArrayList<output_pin> outPinList= new ArrayList<output_pin>();
    ArrayList<Node> nodeList = new ArrayList<Node>();
    ArrayList<CustomComponent> savedCustomComps = new ArrayList<CustomComponent>(); //saved custom comps, nothing else

    ArrayList<CustomComponent> customComponentList= new ArrayList<CustomComponent>();

    int numNodes = 0;


    public Circuit() {
    }

    public void saveCustomComp(CustomComponent comp){

        savedCustomComps.add(comp);
    }



    //Effects: Manually adds nodes to the circuit based on ID, will automatically create all nodes in between
    //Modifies: Node list
    void addNode (int ID){ // add any number of nodes

        if (ID > (numNodes - 1)){

            for (int i = 0; i < ID + 1; i++ ){
                nodeList.add(new Node());}
            numNodes = ID + 1;
        }
    }

    //Effects adds node object to node list
    void addNode (Node n){
        nodeList.add(n);
}
    void addComp (and_2in comp){ //adds component

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

    //Effects: Prints node list in terminal
    public void truthTable_print(){ //truth table method

        int counter = 0b00000000;
        int inCount = 0; //counts number of input pins, useful for printing
        int outCount = 0; //^^ for output pins

        for (input_pin pin : inPinList){ //prints names while counting input pins, should be seperate function

            System.out.print(pin.getName() + " ");

            inCount++;
        }

        System.out.print("| ");

        for (output_pin pin: outPinList){ //counts number of output pins and prints names

            System.out.print(pin.getName() + " ");

            outCount++;
        }


        System.out.println();

        for (int i = 0; i < (inCount + outCount + 1) * 2 ; i++ ){ // prints line under pin names, needs to be more dynamic
            System.out.print("_");
        }
        System.out.println();


        for (input_pin pin : inPinList){ //initializes all inputs at zero
            pin.set(false);

        }


        int numCombinations = (int) Math.pow(2, inCount); //number of possible combinations
        boolean running = true; //stays true while running for tt
        int pinCounter = 0; //initialize pin counter at  0



        while(counter < numCombinations) {

//            /*
           // int pinTracker = 1; //value for pin where each bit represents an input pin, starts at 1

            for (input_pin p : inPinList){ //set all input nodes to no val change
                p.getNode().setValChange(false);

            }

            this.run(); //runs circuit until steady state

            for (input_pin pin : inPinList) { //prints input pin values
                System.out.print(pin.getNode().getStringVal() + " ");
            }

            System.out.print("| ");

            for (output_pin pin : outPinList) { //prints output pin values
                System.out.print(pin.getNode().getStringVal() + " ");
            }

            System.out.println(); //new line for new input

            counter++;

            int pinTracker = 1; //value for pin where each bit represents an input pin, starts at 1

            // needs to set pins properly

            for (int pinIndex = 0; pinIndex < inCount; pinIndex++){

                inPinList.get(pinIndex).set((pinTracker & counter) != 0);

                pinTracker = pinTracker * 2;
            }

        }

        }


    public String toString(){

        String string = "";

        for (Object o : compList) {
            string = string + "\n" + o.toString();
        }
        return string;
    }


    public void runOnce(){ //used to be the run function

        for(int i = 0; i < compList.size(); i++){ //runs eveything one time, should rely on node changes instead, ie: if circuit reaches steady state


            for(and_2in comp : and_2inArrayList){
                comp.run();
            }

            for(or_2in comp : or_2inArrayList){
                comp.run();
            }

            for(not_1in comp : not_1inArrayList){
                comp.run();
            }

        }


    }

    public boolean nodeChanges(){ //if any node has a val change, return true, else it returns false

        for(Node node : nodeList){ //check all nodes

            if(node.getValChange()){
                return true; //return true if even one node has a change
            }
        }

        return false;

    }

    public void run(){

        boolean steadyCheck = false;
        boolean synchronousCheck = false; //true if circuit has clock


        while(!steadyCheck){ //use do while.
           // System.out.println("check");

            runOnce(); //runs once, then should check all nodes
           // System.out.println("runs ");

            if (!nodeChanges()){ // if all nodes have no changes, break out of loop
                 steadyCheck = true;
            }

        }


    }

    public int getNumOuts (){

        return outPinList.size();
    }


    public int getNumIns (){

        return inPinList.size();
    }

    public static void main(String[] args){

        //quick tetsing

    Circuit cirT = new Circuit();


    Node n0 = new Node(); //A
    Node n1 = new Node();
    Node n2 = new Node();
    Node n3 = new Node(); //B
    Node n4 = new Node();
    Node n5 = new Node();
    Node n6 = new Node();

        cirT.addNode(n0);
        cirT.addNode(n1);
        cirT.addNode(n2);
        cirT.addNode(n3);
        cirT.addNode(n4);
        cirT.addNode(n5);
        cirT.addNode(n6);



    cirT.addComp(new and_2in(n0, n1, n2)); // A and NOT B = n2
        cirT.addComp(new not_1in(n3, n1)); // NOT B = n1
        cirT.addComp(new not_1in(n0, n4)); // n4 = NOT A
        cirT.addComp(new and_2in(n3, n4, n5)); // B and NOT A = n5
        cirT.addComp(new or_2in(n5, n2, n6)); // n6 = A XOR B

        cirT.addComp(new input_pin(n0, "A"));
        cirT.addComp(new input_pin(n3, "B"));
        cirT.addComp(new output_pin(n6, "OUT"));


        cirT.truthTable_print();










    }}