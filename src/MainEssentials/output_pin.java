package MainEssentials;

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

        return name + out.getVal();

    }
}
