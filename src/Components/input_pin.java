package Components;

import MainEssentials.Node;

public class input_pin {

    public boolean isSet = false;

    private int ID = inPinID++;
    public static int inPinID = 0;
    private Node in;
    private String name;

    public input_pin(Node in, String name){
        this.in = in;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void unset(){
        isSet = false;
    }

    public void set(boolean setInput){
            in.setVal(setInput);
            isSet = true;

    }


    public boolean getVal(){
        return in.getVal();
    }

    public String toString(){

        if (!isSet){

            return "input_pin: " +  name + ", Node " + in.getID() + " unset ";

        }

        else return "input_pin: " +  name + ", Node " + in.getID() + ", Value " + in.getStringVal();
    }

    public int getID(){

        return this.ID;
    }

    public Node getNode() {
        return in;
    }

    public void run(){


    }

}

