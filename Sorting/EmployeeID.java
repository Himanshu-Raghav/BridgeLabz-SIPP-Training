package sorting_package;

public class EmployeeID {
    public static void main(String[] args) {
        int[] empIDs = {4, 1, 9, 3, 2, 5};
        int n = empIDs.length;

        //Insertion Sort
        for (int i = 1; i < n; i++) {
            int key = empIDs[i];
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && empIDs[j] > key) {
                empIDs[j + 1] = empIDs[j];
                j--;
            }
            empIDs[j + 1] = key;
        }

        //Print sorted employee ID
        System.out.println("Sorted Employee IDs:");
        for (int id : empIDs) {
            System.out.print(id + " ");
        }
    }
}

