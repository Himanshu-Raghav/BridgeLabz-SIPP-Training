package stack_queue_package;

import java.util.*;

public class CircularTour {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int start = findStartPoint(petrol, distance);
        
        if (start == -1)
            System.out.println("No possible tour");
        else
            System.out.println("Start at pump: " + start);
    }

    public static int findStartPoint(int[] petrol, int[] distance) {
        int total = 0;   // Total fuel
        int curr = 0;    // Current fuel 
        int start = 0;   // Candidate starting pump

        for (int i = 0; i < petrol.length; i++) {
            int gain = petrol[i] - distance[i]; 
            
            total += gain;
            curr += gain;   

            if (curr < 0) {
                start = i + 1;
                curr = 0;     
            }
        }
        return (total >= 0) ? start : -1;
    }
}


