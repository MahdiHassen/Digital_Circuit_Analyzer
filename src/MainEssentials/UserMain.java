package MainEssentials;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;




public class UserMain {



    public static void main(String[] args) {

        Scanner userIn = new Scanner(System.in); // scanner

        Circuit cir1 = Circuit.getInstance(); //new circuit

        ArrayList<Node> nodeList = new ArrayList<Node>(); //list of nodes used in Cir

        int maxNodeID = 0;

        System.out.println("Input Components:");

        while(true){

        String input = userIn.nextLine();

            String[] inputArray = input.split(" ");

            if (Objects.equals(input, "end")){
            System.out.println("ALL DONE");
            break;
        }

        else if (Objects.equals(input, "print")){
            System.out.println(cir1.toString());
        }
              else
                if (Objects.equals(inputArray[0], "input")) {

                    //compList

                }

                else System.out.println("Input Valid Component");

    }}}
