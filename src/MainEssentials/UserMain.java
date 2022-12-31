package MainEssentials;

import Components.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;




public class UserMain {



    public static void main(String[] args) {

        boolean inputStatus = true; //true= user input, false = text file input

        Scanner userIn = new Scanner(System.in); // creates scanner for user/textdoc input

        Circuit cir1 = Circuit.getInstance(); //new circuit

        //ArrayList<Node> nodeList = new ArrayList<Node>(); //list of nodes used in Cir
        //int maxNodeID = 0;

        System.out.println("Input Components:");

        while(inputStatus){

            String input = userIn.nextLine(); //only based on user input

            String[] inputArray = input.split(" "); //split array by spaces

            if (Objects.equals(input, "end")){ //end condition, quits program
            System.out.println("ALL DONE");
            break;
        }

            else if (Objects.equals(input, "print")){ //prints circuit, should only be in user input mode
            System.out.println(cir1.toString());

        }
            else if (Objects.equals(inputArray[0], "input")) { //input command inputs components into circuit

                    String component = inputArray[1];
                    String name = inputArray[2];


                if(Objects.equals(component , "input_pin")){ //adding input pin format: input input_pin "name" "nodeNum"  set/unset "val (0 or 1)"

                            int Node = Integer.parseInt(inputArray[3]);

                            cir1.addNode(Node);
                            input_pin pin = new input_pin(cir1.nodeList.get(Node), name);
                            cir1.addComp(pin);


                            if (Objects.equals(inputArray[4], "set")){
                                if (Objects.equals(inputArray[5], "1")) {
                                    pin.set(true);

                                }

                                else if (Objects.equals(inputArray[5], "0")){
                                    pin.set(false);}


                                else System.out.println("invalid value, must be 0 or 1");
                                }

                            else if (Objects.equals(inputArray[4], "unset")){

                            }

                            else System.out.println("pin must be set or unset");}

                else if(Objects.equals(component, "output_pin")) { // adding output pin format: input output_pin "nodeNum" "name"

                    int Node = Integer.parseInt(inputArray[3]);
                    cir1.addNode(Node);
                    output_pin pin = new output_pin(cir1.nodeList.get(Node), name);
                    cir1.addComp(pin);

                        }

                else if (Objects.equals(component, "and_2in")){ //adding 2in 1out format: input "comp (like and_2in)" "nodeIn1#" "nodeIn2#" "nodeOut1#"

                    int inNode1 = Integer.parseInt(inputArray[2]);
                    int inNode2 = Integer.parseInt(inputArray[3]);
                    int outNode1 = Integer.parseInt(inputArray[4]);

                    cir1.addNode(inNode1); cir1.addNode(inNode2); cir1.addNode(outNode1); // adds potential nodes to circuit

                    and_2in gate = new and_2in(cir1.nodeList.get(inNode1),cir1.nodeList.get(inNode2), cir1.nodeList.get(outNode1));
                    cir1.addComp(gate);

                }

                else if (Objects.equals(component, "or_2in")){ //adding 2in 1out format: input "comp (like or_2in)" "nodeIn1#" "nodeIn2#" "nodeOut1#"

                    int inNode1 = Integer.parseInt(inputArray[2]);
                    int inNode2 = Integer.parseInt(inputArray[3]);
                    int outNode1 = Integer.parseInt(inputArray[4]);

                    cir1.addNode(inNode1); cir1.addNode(inNode2); cir1.addNode(outNode1); // adds potential nodes to circuit

                    or_2in gate = new or_2in(cir1.nodeList.get(inNode1),cir1.nodeList.get(inNode2), cir1.nodeList.get(outNode1));
                    cir1.addComp(gate);

                }

                else if (Objects.equals(component, "not_1in")){ //adding 1in 1out format: input "comp (like not_1in)" "nodeIn1#" "nodeOut1#"

                    int inNode1 = Integer.parseInt(inputArray[2]);
                    int outNode1 = Integer.parseInt(inputArray[3]);

                    cir1.addNode(inNode1); cir1.addNode(outNode1); // adds potential nodes to circuit

                    not_1in gate = new not_1in(cir1.nodeList.get(inNode1), cir1.nodeList.get(outNode1));
                    cir1.addComp(gate);

                }

                        else throw new IllegalStateException("Unexpected value: " + inputArray[1]);


                }

            else if (Objects.equals(inputArray[0], "run")){

                System.out.println("Running...");
                cir1.run();

            }

            else if (Objects.equals(inputArray[0], "set")){

               String name = inputArray[1];
               String val = inputArray[2];

               for (input_pin pin : cir1.inPinList){

                    if (Objects.equals(pin.getName(), name)){

                        if(Objects.equals(val, "1")){
                            pin.set(true);
                        }

                        if(Objects.equals(val, "0")){
                            pin.set(false);
                        }

                        if(Objects.equals(val, "unset")){
                            pin.unset();
                        }
                    }

               }

            }

            else if (Objects.equals(inputArray[0], "tt")){ //truth table

                System.out.println("Generating Truth Table...");



            }

            else System.out.println("Input Valid command");

    }}}

