package Components;

import MainEssentials.Node;

public class output_pin {

    Node out;
    String name;

    public output_pin(Node out, String name){

        this.out = out;
        this.name = name;

    }

    public boolean getVal(){

        return out.getVal();
    }

    public String listVal(){

        return "output pin:" + name + " " + out.getVal();

    }

    public void run(){

    }

    public String getName() {
        return name;
    }


    public String toString(){
        return "output_pin: " +  name + ", Node " + out.getID();
    }

}
