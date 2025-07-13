package sorting_package;

public class StudentMarks {
    public static void main(String[] args) {
        int[] marks = {85, 70, 90, 60, 75, 95, 80};
        int n = marks.length;

        //Bubble Sort logic
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                	
                    //Swap marks[j] and marks[j+1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
            	break; 
            }
        }

        //Print sorted marks
        System.out.println("Sorted Student Marks:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}

