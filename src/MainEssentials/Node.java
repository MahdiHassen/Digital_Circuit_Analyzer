package MainEssentials;

public class Node {
    private int ID = nodeID++;
    public static int nodeID = 0;
    public boolean hasVal;
    private boolean val;

    public Node(){ // sets hasVal false, AKA not HIGH or LOW
        this.hasVal = false;
    }

    public void setVal(boolean val) { //sets Value of node to HIGH or LOW
        this.val = val;
        this.hasVal = true;
    }

    public void setVal(int val) throws Exception { //sets Value of node to HIGH or LOW
        if (val == 1){
            this.val = true;
        }

        else if (val == 0){
            this.val = false;
        }

        else{
            throw new Exception("Node must take 0 or 1");
        }
        this.hasVal = true;
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


    public static void main(String[] args) throws Exception { //test node ID and val

        Node node1 = new Node();
        node1.setVal(0);
        Node node2 = new Node();
        Node node3 = new Node();

        System.out.println("node1 is: " + node1.toString() + "\nnode3 is: " + node3.toString());

    }
}
