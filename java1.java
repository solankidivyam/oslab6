//Divyam Solanki
//201951198
//Section - 2D

import java.io.FileWriter;

import java.util.Scanner;

import java.io.IOException;

public class java1 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.print("\nTotal number of processes (say 5) : : ");
        int num = scan.nextInt();

        FileWriter filep = new FileWriter("ourdata.dat");

        filep.write(Integer.toString(num));
        filep.write("\n");

        for (int i = 0; i < num; i++) {
            System.out.println("\nGive below the details for the processe " + (i + 1) + " : ");

            System.out.print("Give me the process ID : ");
            String process_id = scan.next();

            System.out.print("Say the arrival time :");
            int arrival = scan.nextInt();

            System.out.print("Just tell me the processing time : ");
            int processing = scan.nextInt();

            System.out.print("I/O interruting time : ");
            float input_output_time = scan.nextFloat();

            System.out.print("Wait timeee : ");
            float wait = scan.nextFloat();

            System.out.print("You say what shall we put the priority here :  ");
            int priority = scan.nextInt();

            filep.write(process_id);
            filep.write(",");

            filep.write(Integer.toString(arrival));
            filep.write(",");


            filep.write(Integer.toString(processing));
            filep.write(",");

            filep.write(Float.toString(input_output_time));
            filep.write(",");

            filep.write(Float.toString(wait));
            filep.write(",");

            filep.write(Integer.toString(priority));
            filep.write("\n");
        }

        filep.close();
        scan.close();
    }
}