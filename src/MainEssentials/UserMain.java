package MainEssentials;

import Components.input_pin;
import Components.output_pin;

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
                    String name = inputArray[3];


                if(Objects.equals(component , "input_pin")){ //adding input pin format: input input_pin "nodeNum" "name" set/unset "val (0 or 1)"

                            int Node = Integer.parseInt(inputArray[2]);

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

                            int Node = Integer.parseInt(inputArray[2]);
                            cir1.addNode(Node);
                            output_pin pin = new output_pin(cir1.nodeList.get(Node), name);
                            cir1.addComp(pin);

                        }


                        else throw new IllegalStateException("Unexpected value: " + inputArray[1]);


                }

            else System.out.println("Input Valid Component");

    }}}

//input input_pin 2 Hafsa set 1