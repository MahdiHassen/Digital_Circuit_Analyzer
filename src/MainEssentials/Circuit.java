package MainEssentials;

import Components.*;

import java.util.ArrayList;


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


    public void tt(){ //truth table method

        int counter = 0b00000000;
        int inCount = 0;
        int outCount = 0;

        for (input_pin pin : inPinList){

            System.out.print(pin.getName() + " ");

            inCount++;
        }

        System.out.print("| ");

        for (output_pin pin: outPinList){

            System.out.print(pin.getName() + " ");

            outCount++;
        }

        System.out.println();
        for (int i = 0; i < (inCount + outCount + 1) * 2 ; i++ ){ //make this work later
            System.out.print("_");
        }
        System.out.println();


        for (input_pin pin : inPinList){ //initializes all inputs at zero
            pin.set(false);
        }

        for(int i = 0; i < Math.pow(2, inCount); i++){

            this.run();

            for(input_pin pin: inPinList){
                System.out.print(pin.getNode().getStringVal() + " ");
            }

            System.out.print("| ");

            for(output_pin pin: outPinList){
               System.out.print(pin.getNode().getStringVal() + " ");
            }

            System.out.println();

            counter++;
            int pinCounter = 0;
            for(int j = 1;  j < Math.pow(2, inPinList.size()); j = j * 2){ // j goes from 0b00001 to 0b00010 to 0b00100... every loop


                //System.out.println(j);

                if ((j & counter) != 0){ //if pin should be HIGH

                    //System.out.println("     f     ");
                    inPinList.get(pinCounter).set(true);

                }

                else inPinList.get(pinCounter).set(false);

                pinCounter++;
            }
        }

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

        for(int i = 0; i < compList.size(); i++){


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


        //for(output_pin pin: outPinList){
          //  System.out.println(pin.listVal());
       // }
    }
}
