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

    public input_pin(Node in){
        this.in = in;
        name = "untitledPin_" + inPinID;

    }

    public void set(boolean setInput){
            in.setVal(setInput);
            isSet = true;

    }

    public boolean getVal(){
        return in.getVal();
    }

    public String toString(){
        return name + " " + in.getVal();
    }




}

