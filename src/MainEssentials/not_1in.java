package MainEssentials;

public class not_1in extends Component{

    Node in1, out;
    public int num_in = 1;
    public int num_out = 1;

    public not_1in(Node in1, Node out) {
        this.in1 = in1;
        this.out = out;

        super.num_in = num_in;
        super.num_out = num_out;

        super.setName("not_1in");

    }

    public String toString(){

        return this.name + " ins: " + in1.getID() + " outs: " + out.getID();

    }

    public void run(){
        out.setVal(!in1.getVal());
    }
}