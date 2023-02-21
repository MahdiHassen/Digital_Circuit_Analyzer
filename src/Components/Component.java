package Components;

import MainEssentials.Node;

abstract class Component {

    private final int ID = compID++;
    public static int compID = 0;
    protected int num_in, num_out;
    private String description = "no description provided";
    protected String name = "no name provided";

    public Component(int num_in, int num_out, String name, String description){
        this.num_in =  num_in;
        this.num_out = num_out;
        this.name = name;
        this.description = description;
    }

    public int getID(){
        return this.ID;
    }

    public int getNum_in() {
        return num_in;
    }

    public int getNum_out() {
        return num_out;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String info(){

        return "Component Name: " + this.name + "\n Desc:" + this.description + "\n Num Ins: " + num_in + " ,Num outs: " + num_out;
    }

    public void run(){



    }


}
