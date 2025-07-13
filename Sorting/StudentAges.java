package sorting_package;

public class StudentAges {

    //Counting Sort
    public static void countingSort(int[] ages) {
        int min = 10;
        int max = 18;
        int range = max - min + 1;

        //Count array to store frequency of each age
        int[] count = new int[range];

        // Output array to store sorted ages
        int[] output = new int[ages.length];

        //Store the count of each age
        for (int age : ages) {
            count[age - min]++;
        }

        //Update the count array with cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        //Build the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        //Copy sorted ages back to original array
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] studentAges = {12, 15, 11, 14, 10, 18, 13, 17, 12, 11};

        System.out.println("Original Student Ages:");
        for (int age : studentAges)
            System.out.print(age + " ");

        countingSort(studentAges);

        System.out.println("\n\nSorted Student Ages:");
        for (int age : studentAges)
            System.out.print(age + " ");
    }
}

