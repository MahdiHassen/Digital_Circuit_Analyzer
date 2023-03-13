package Components;

import MainEssentials.Node;

public class Clock
{
    private int period = 0; //(ns)
    private Node out;


    public Clock(int period, Node out ){

        this.period = period;
        this.out= out;

    }

    public int getPeriod(){

        return this.period;
    }




}
