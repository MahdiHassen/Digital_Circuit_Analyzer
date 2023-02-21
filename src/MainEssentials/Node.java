package MainEssentials;

public class Node {
    private int ID = nodeID++;
    public static int nodeID = 0;
    public boolean hasVal;
    private boolean val;
    private boolean valChange;



    public Node(){ // sets hasVal false, AKA not HIGH or LOW,  val change on

        this.valChange = false;
        this.hasVal = false;
    }

    public Node(boolean valChange){
        this.hasVal = false;
        this.valChange = valChange;

    }

    public void setValChange(boolean valChange){

        this.valChange = valChange;
    }
    public boolean getValChange(){ //returns true if value has changed

        return this.valChange;
    }

    public void setVal(boolean val) { //sets Value of node to HIGH or LOW

        if (this.hasVal){

            if (this.getVal() != val){ //if value changes turn val change to true

                this.valChange= true;
                this.val = val;}

            else{//if value doesn't change

                    this.valChange = false;

            }
        }
        else{ //if it doesnt have a previous value just ignore it since val change is on by default

            this.val = val;
            this.hasVal = true;

        }


    }

    public void setVal(int val) throws Exception { //sets Value of node to HIGH or LOW, dont use this yet, weird things happen
        if (val == 1){
            this.setVal(true);
        }

        else if (val == 0){
            this.setVal(false);
        }

        else{
            throw new IllegalArgumentException("Node must take 0 or 1");
        }
        //this.setVal(true);
    }

    public boolean getVal(){
        return val;
    }

    public int getID() {
        return ID;

    }
    
    public String getStringVal(){

        String out = null;

        if(hasVal){
            if(val){
                out = "1";
            }
            if (!val){
                out = "0";
            }
        }

        else {
            out = "noVal";
        }

        return out;
    }

    public String toString() {
        String out = this.getStringVal();

        return String.valueOf(this.ID) + " value: " + out;
    }

 public boolean getHasVal(){

        return this.hasVal;
 }




    
}
