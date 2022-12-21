package MainEssentials;

public class or_2in extends Component{

    Node in1, in2, out;
    public int num_in = 2;
    public int num_out = 1;

    public or_2in(Node in1, Node in2, Node out) {
        this.in1 = in1;
        this.in2 = in2;
        this.out = out;

        super.num_in = num_in;
        super.num_out = num_out;

        super.setName("or_2in");

    }

    public String toString(){

        return this.getID() + " " + this.name + " ins: " + in1.getID() + " " + in2.getID() + " outs: " + out.getID();

    }

    public void run(){
        out.setVal(in1.getVal() || in2.getVal());
    }
}
