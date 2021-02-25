//Divyam Solanki
//201951198
//Section - 2D

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java2 {
    public static void main(String[] args) throws IOException {

        FileReader fileread = null;

        try {
            fileread = new FileReader(args[0]);

            Scanner scan = new Scanner(new File(args[0]));

            String number = scan.nextLine();
            int n = Integer.parseInt(number);

            String[] process_id = new String[n];
            int[] arrival = new int[n];
            int[] remaining = new int[n];
            int[] processing = new int[n];
            int[] compound_time = new int[n];
            float[] input_output_time = new float[n];
            float[] wait = new float[n];

            for (int i = 0; i < n; i++) {
                String current = scan.nextLine(), temp = "";
                int cnt = 0;

                for (int j = 0; j < current.length(); j++) {
                    if (current.charAt(j) == ',') {
                        if (cnt == 0) {
                            process_id[i] = temp;
                        } else if (cnt == 1) {
                            arrival[i] = Integer.parseInt(temp);
                        } else if (cnt == 2) {
                            processing[i] = Integer.parseInt(temp);
                            remaining[i] = Integer.parseInt(temp);
                        } else if (cnt == 3) {
                            input_output_time[i] = Float.parseFloat(temp);
                        } else if (cnt == 4) {
                            wait[i] = Float.parseFloat(temp);
                        } else {
                            continue;
                        }

                        temp = "";
                        cnt++;

                    } else {
                        temp += current.charAt(j);
                    }
                }
            }

            int time = 0, time_quantam = 1;

            while (true) {
                boolean val = true;

                for (int i = 0; i < n; i++) {
                    if (remaining[i] > 0) {
                        val = false;

                        if (remaining[i] > time_quantam && arrival[i] <= time) {
                            remaining[i] -= time_quantam;
                            time += time_quantam;
                        } else if (remaining[i] <= time_quantam) {
                            time += remaining[i];
                            remaining[i] = 0;
                            compound_time[i] = time;
                        }
                    }
                }

                if (val == true)
                    break;
            }

            float[] tat_time = new float[n];
            float[] wait_time = new float[n];
            float totaltime_waiting = 0, totaltime_turnaround = 0;

            for (int i = 0; i < n; i++) {
                tat_time[i] = (compound_time[i] - arrival[i]) + wait[i];
                wait_time[i] = (tat_time[i] - processing[i]) - input_output_time[i];

                totaltime_waiting += wait_time[i];
                totaltime_turnaround += tat_time[i];

                System.out.println("The Turn Around and Wait time for process : " + process_id[i] + " is " + tat_time[i] + " and "
                        + wait_time[i]);
            }

            System.out.println("\nTotal Turn Around time : " + totaltime_turnaround / (float) n);
            System.out.println("Total Waiting Around time : " + totaltime_waiting / (float) n);
        } catch (Exception e) {
            System.out.println("\n\n No file found here man! \n\n");
        }

    }
}
