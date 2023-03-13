package Components;

import MainEssentials.Circuit;

public class CustomComponent extends Component{

    Circuit component;
    

    public CustomComponent(Circuit component, String name, String description) {

        super(component.getNumIns(), component.getNumOuts(), name, description);

        this.component = component;

    }

    public void saveIn(Circuit savedToCircuit){

        savedToCircuit.saveCustomComp(this);
    }







}
