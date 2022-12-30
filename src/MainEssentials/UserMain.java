package MainEssentials;

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

                    //compList

                }

            else System.out.println("Input Valid Component");

    }}}
